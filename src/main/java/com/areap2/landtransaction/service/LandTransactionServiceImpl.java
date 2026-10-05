package com.areap2.landtransaction.service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.areap2.entity.AuditLog;
import com.areap2.landtransaction.dto.ExcelUploadResponse;
import com.areap2.landtransaction.dto.LandTransactionRequest;
import com.areap2.landtransaction.dto.LandTransactionResponse;
import com.areap2.landtransaction.dto.PageResponse;
import com.areap2.landtransaction.entity.LandTransaction;
import com.areap2.landtransaction.repository.LandTransactionRepository;
import com.areap2.landtransaction.util.LandTransactionFingerprint;
import com.areap2.repository.AuditLogRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LandTransactionServiceImpl implements LandTransactionService {

	private static final Logger log = LoggerFactory.getLogger(LandTransactionServiceImpl.class);
	private static final int BATCH_SIZE = 500;
	private static final String FEATURE = "LandTransaction";

	private static final List<String> REQUIRED_HEADERS = List.of("District", "Circle", "Mouza", "Lot", "Village",
			"Dag No", "NIC Code", "Consideration Value", "Date");

	private final LandTransactionRepository repository;
	private final AuditLogRepo auditLogRepo;

	public LandTransactionServiceImpl(LandTransactionRepository repository, AuditLogRepo auditLogRepo) {
		this.repository = repository;
		this.auditLogRepo = auditLogRepo;
	}

	@Override
	@Transactional
	public LandTransactionResponse create(LandTransactionRequest request) {
		String user = currentUser();
		LandTransaction entity = fromRequest(request);
		entity.setCreatedBy(user);
		entity.setUpdatedBy(user);
		entity.setFingerprint(fingerprint(entity));

		if (repository.findByFingerprint(entity.getFingerprint()).isPresent()) {
			throw new IllegalArgumentException("Duplicate land transaction already exists");
		}

		LandTransaction saved = repository.save(entity);
		writeAudit("CREATE", saved, null, saved.getConsiderationValue(), "Land transaction created");
		log.info("Land transaction created. id={}, user={}", saved.getId(), user);
		return toResponse(saved);
	}

	@Override
	@Transactional(readOnly = true)
	public LandTransactionResponse getById(Long id) {
		return toResponse(find(id));
	}

	@Override
	@Transactional(readOnly = true)
	public PageResponse<LandTransactionResponse> search(String district, String circle, String mouza, String village,
			String dagNo, String nicCode, Boolean active, Pageable pageable) {

		Specification<LandTransaction> spec = Specification.where(null);

		if (hasText(district))
			spec = spec.and(like("district", district));
		if (hasText(circle))
			spec = spec.and(like("circle", circle));
		if (hasText(mouza))
			spec = spec.and(like("mouza", mouza));
		if (hasText(village))
			spec = spec.and(like("village", village));
		if (hasText(dagNo))
			spec = spec.and(like("dagNo", dagNo));
		if (hasText(nicCode))
			spec = spec.and(like("nicCode", nicCode));
		if (active != null)
			spec = spec.and((root, q, cb) -> cb.equal(root.get("active"), active));

		Page<LandTransaction> page = repository.findAll(spec, pageable);
		List<LandTransactionResponse> content = page.getContent().stream().map(this::toResponse).toList();

		return new PageResponse<>(content, page.getNumber(), page.getSize(), page.getTotalElements(),
				page.getTotalPages(), page.isFirst(), page.isLast());
	}

	@Override
	@Transactional
	public LandTransactionResponse update(Long id, LandTransactionRequest request) {
		LandTransaction entity = find(id);
		String user = currentUser();

		BigDecimal oldValue = entity.getConsiderationValue();

		entity.setDistrict(request.district().trim());
		entity.setCircle(request.circle().trim());
		entity.setMouza(request.mouza().trim());
		entity.setLot(request.lot().trim());
		entity.setVillage(request.village().trim());
		entity.setDagNo(request.dagNo().trim());
		entity.setNicCode(request.nicCode().trim());
		entity.setConsiderationValue(request.considerationValue());
		entity.setTransactionDate(request.transactionDate());
		entity.setUpdatedBy(user);
		entity.setFingerprint(fingerprint(entity));

		if (repository.existsByFingerprintAndIdNot(entity.getFingerprint(), id)) {
			throw new IllegalArgumentException("Another land transaction with the same business data already exists");
		}

		LandTransaction saved = repository.save(entity);
		writeAudit("UPDATE", saved, oldValue, saved.getConsiderationValue(), "Land transaction updated");
		log.info("Land transaction updated. id={}, user={}", id, user);
		return toResponse(saved);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		LandTransaction entity = find(id);
		BigDecimal oldValue = entity.getConsiderationValue();
		entity.setActive(false);
		entity.setUpdatedBy(currentUser());
		repository.save(entity);
		writeAudit("DELETE", entity, oldValue, null, "Land transaction deactivated");
		log.info("Land transaction deactivated. id={}, user={}", id, currentUser());
	}

	@Override
	@Transactional
	public void restore(Long id) {
		LandTransaction entity = find(id);
		entity.setActive(true);
		entity.setUpdatedBy(currentUser());
		repository.save(entity);
		writeAudit("RESTORE", entity, entity.getConsiderationValue(), entity.getConsiderationValue(),
				"Land transaction restored");
		log.info("Land transaction restored. id={}, user={}", id, currentUser());
	}

	@Override
	@Transactional
	public ExcelUploadResponse uploadExcel(MultipartFile file) throws IOException {
		validateFile(file);

		int total = 0, inserted = 0, duplicate = 0, failed = 0;
		List<ExcelUploadResponse.RowError> errors = new ArrayList<>();
		List<LandTransaction> batch = new ArrayList<>(BATCH_SIZE);
		Set<String> batchFingerprints = new HashSet<>(BATCH_SIZE);
		String user = currentUser();

		log.info("Excel upload started. file={}, user={}, size={}", file.getOriginalFilename(), user, file.getSize());

		try (InputStream inputStream = file.getInputStream(); Workbook workbook = WorkbookFactory.create(inputStream)) {

			if (workbook.getNumberOfSheets() == 0) {
				throw new IllegalArgumentException("Excel file contains no sheets");
			}

			Sheet sheet = workbook.getSheetAt(0);
			DataFormatter formatter = new DataFormatter(Locale.ENGLISH);
			Row header = sheet.getRow(0);
			validateHeaders(header, formatter);

			for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				if (isBlankRow(row, formatter))
					continue;

				total++;
				int excelRow = rowIndex + 1;

				try {
					LandTransaction entity = parseRow(row, formatter);
					entity.setCreatedBy(user);
					entity.setUpdatedBy(user);
					entity.setFingerprint(fingerprint(entity));

					if (repository.findByFingerprint(entity.getFingerprint()).isPresent()
							|| !batchFingerprints.add(entity.getFingerprint())) {
						duplicate++;
						continue;
					}

					batch.add(entity);
					inserted++;

					if (batch.size() == BATCH_SIZE) {
						repository.saveAll(batch);
						repository.flush();
						batch.clear();
						batchFingerprints.clear();
					}
				} catch (Exception ex) {
					failed++;
					errors.add(new ExcelUploadResponse.RowError(excelRow, ex.getMessage()));
					log.warn("Excel row rejected. row={}, reason={}", excelRow, ex.getMessage());
				}
			}

			if (!batch.isEmpty()) {
				repository.saveAll(batch);
				repository.flush();
			}

			log.info("Excel upload completed. file={}, total={}, inserted={}, duplicates={}, failed={}",
					file.getOriginalFilename(), total, inserted, duplicate, failed);

			if (!errors.isEmpty()) {
				// The import keeps valid rows and reports invalid rows.
				// This is intentional so one bad row does not discard a large upload.
			}

			return new ExcelUploadResponse(file.getOriginalFilename(), total, inserted, duplicate, failed, errors);
		} catch (IllegalArgumentException ex) {
			throw ex;
		} catch (Exception ex) {
			log.error("Excel upload failed. file={}, user={}", file.getOriginalFilename(), user, ex);
			throw new IOException("Unable to process Excel file: " + ex.getMessage(), ex);
		}
	}

//	private LandTransaction parseRow(Row row, DataFormatter formatter) {
//
//		String district = requiredText(row, 0, formatter, "District");
//		String circle = requiredText(row, 1, formatter, "Circle");
//		String mouza = requiredText(row, 2, formatter, "Mouza");
//		String lot = requiredText(row, 3, formatter, "Lot");
//		String village = requiredText(row, 4, formatter, "Village");
//		String dagNo = requiredText(row, 5, formatter, "Dag No");
//		String nicCode = requiredText(row, 6, formatter, "NIC Code");
//
//		BigDecimal consideration = decimal(row, 7, formatter, "Consideration Value");
//
//		LocalDate date = date(row, 8, formatter, "Date");
//
//		LandTransaction transaction = new LandTransaction();
//
//		transaction.setDistrict(district);
//		transaction.setCircle(circle);
//		transaction.setMouza(mouza);
//		transaction.setLot(lot);
//		transaction.setVillage(village);
//		transaction.setDagNo(dagNo);
//		transaction.setNicCode(nicCode);
//		transaction.setConsiderationValue(consideration);
//		transaction.setTransactionDate(date);
//		transaction.setActive(true);
//
//		return transaction;
//	}

	private LandTransaction parseRow(Row row, DataFormatter formatter) {

		String district = requiredText(row, 0, formatter, "District");
		String circle = requiredText(row, 1, formatter, "Circle");
		String mouza = requiredText(row, 2, formatter, "Mouza");
		String lot = requiredText(row, 3, formatter, "Lot");
		String village = requiredText(row, 4, formatter, "Village");
		String dagNo = requiredText(row, 5, formatter, "Dag No");
		String nicCode = requiredText(row, 6, formatter, "NIC Code");

		BigDecimal consideration = decimal(row, 7, formatter, "Consideration Value");

		LocalDate date = date(row, 8, formatter, "Date");

		LandTransaction transaction = new LandTransaction();

		transaction.setDistrict(district);
		transaction.setCircle(circle);
		transaction.setMouza(mouza);
		transaction.setLot(lot);
		transaction.setVillage(village);
		transaction.setDagNo(dagNo);
		transaction.setNicCode(nicCode);
		transaction.setConsiderationValue(consideration);
		transaction.setTransactionDate(date);
		transaction.setActive(true);

		return transaction;
	}

	private LocalDate date(Row row, int index, DataFormatter formatter, String fieldName) {

		Cell cell = row.getCell(index);

		if (cell == null || cell.toString().trim().isEmpty()) {
			throw new IllegalArgumentException(fieldName + " is required");
		}

		try {

			if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {

				return cell.getLocalDateTimeCellValue().toLocalDate();
			}

			String value = formatter.formatCellValue(cell).trim();

			DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			return LocalDate.parse(value, formatter1);

		} catch (Exception e) {

			throw new IllegalArgumentException("Invalid " + fieldName + " at Excel row " + (row.getRowNum() + 1));
		}
	}

	private String requiredText(Row row, int index, DataFormatter formatter, String field) {
		String value = formatter.formatCellValue(row.getCell(index));
		if (!hasText(value))
			throw new IllegalArgumentException(field + " is required");
		return value.trim();
	}

	private BigDecimal decimal(Row row, int index, DataFormatter formatter, String field) {
		String value = requiredText(row, index, formatter, field).replace(",", "");
		try {
			BigDecimal result = new BigDecimal(value);
			if (result.signum() < 0)
				throw new IllegalArgumentException(field + " cannot be negative");
			return result;
		} catch (NumberFormatException ex) {
			throw new IllegalArgumentException(field + " must be a valid number");
		}
	}

//	private LocalDate date(Row row, int index, DataFormatter formatter, String field) {
//		Cell cell = row.getCell(index);
//		if (cell == null)
//			throw new IllegalArgumentException(field + " is required");
//
//		try {
//			if (cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
//				return cell.getLocalDateTimeCellValue().toLocalDate();
//			}
//
//			String value = formatter.formatCellValue(cell).trim();
//			for (DateTimeFormatter f : List.of(DateTimeFormatter.ofPattern("dd-MM-yyyy"),
//					DateTimeFormatter.ofPattern("dd/MM/yyyy"), DateTimeFormatter.ISO_LOCAL_DATE)) {
//				try {
//					return LocalDate.parse(value, f);
//				} catch (DateTimeParseException ignored) {
//				}
//			}
//			throw new IllegalArgumentException(field + " must be in dd-MM-yyyy format");
//		} catch (IllegalArgumentException ex) {
//			throw ex;
//		} catch (Exception ex) {
//			throw new IllegalArgumentException("Invalid " + field);
//		}
//	}

	private void validateHeaders(Row header, DataFormatter formatter) {
		if (header == null)
			throw new IllegalArgumentException("Excel header row is missing");

		for (int i = 0; i < REQUIRED_HEADERS.size(); i++) {
			String actual = formatter.formatCellValue(header.getCell(i)).trim();
			if (!REQUIRED_HEADERS.get(i).equalsIgnoreCase(actual)) {
				throw new IllegalArgumentException("Invalid Excel header at column " + (i + 1) + ". Expected '"
						+ REQUIRED_HEADERS.get(i) + "' but found '" + actual + "'");
			}
		}
	}

	private boolean isBlankRow(Row row, DataFormatter formatter) {
		if (row == null)
			return true;
		for (int i = 0; i < REQUIRED_HEADERS.size(); i++) {
			if (hasText(formatter.formatCellValue(row.getCell(i))))
				return false;
		}
		return true;
	}

	private void validateFile(MultipartFile file) {
		if (file == null || file.isEmpty())
			throw new IllegalArgumentException("Excel file is required");
		String name = file.getOriginalFilename();
		if (name == null || !(name.toLowerCase(Locale.ROOT).endsWith(".xlsx")
				|| name.toLowerCase(Locale.ROOT).endsWith(".xls"))) {
			throw new IllegalArgumentException("Only .xlsx and .xls files are supported");
		}
	}

	private LandTransaction find(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Land transaction not found: " + id));
	}

	private Specification<LandTransaction> like(String field, String value) {
		return (root, query, cb) -> cb.like(cb.lower(root.get(field).as(String.class)),
				"%" + value.trim().toLowerCase(Locale.ROOT) + "%");
	}

	private String fingerprint(LandTransaction e) {
		return LandTransactionFingerprint.create(e.getDistrict(), e.getCircle(), e.getMouza(), e.getLot(),
				e.getVillage(), e.getDagNo(), e.getNicCode(), e.getConsiderationValue(), e.getTransactionDate());
	}

	private LandTransactionResponse toResponse(LandTransaction e) {
		return new LandTransactionResponse(e.getId(), e.getDistrict(), e.getCircle(), e.getMouza(), e.getLot(),
				e.getVillage(), e.getDagNo(), e.getNicCode(), e.getConsiderationValue(), e.getTransactionDate(),
				e.getActive(), e.getCreatedAt(), e.getUpdatedAt(), e.getCreatedBy(), e.getUpdatedBy());
	}

	private LandTransaction fromRequest(LandTransactionRequest r) {

		LandTransaction transaction = new LandTransaction();

		transaction.setDistrict(r.district().trim());
		transaction.setCircle(r.circle().trim());
		transaction.setMouza(r.mouza().trim());
		transaction.setLot(r.lot().trim());
		transaction.setVillage(r.village().trim());
		transaction.setDagNo(r.dagNo().trim());
		transaction.setNicCode(r.nicCode().trim());
		transaction.setConsiderationValue(r.considerationValue());
		transaction.setTransactionDate(r.transactionDate());
		transaction.setActive(true);

		return transaction;
	}

	private void writeAudit(String action, LandTransaction entity, BigDecimal oldValue, BigDecimal newValue,
			String message) {
		try {
			AuditLog logEntity = new AuditLog();
			logEntity.setLoginId(currentUser());
			logEntity.setFeatureName(FEATURE);
			logEntity.setActionType(action);
			logEntity.setActionDatetime(java.sql.Timestamp.valueOf(java.time.LocalDateTime.now()));
			logEntity.setFeatureDescription("Land transaction");
			logEntity.setMessage(message);
			logEntity.setStatus(entity.getActive() ? "active" : "inactive");
			logEntity.setReferenceId(entity.getId());
			logEntity.setOldValue(oldValue);
			logEntity.setNewValue(newValue);
			logEntity.setUpdatedBy(currentUser());
			auditLogRepo.save(logEntity);
		} catch (Exception ex) {
			// Do not hide the business operation because audit logging failed.
			log.error("Audit log write failed. feature={}, referenceId={}, action={}", FEATURE, entity.getId(), action,
					ex);
		}
	}

	private String currentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth != null && auth.isAuthenticated() && auth.getName() != null ? auth.getName() : "SYSTEM";
	}

	private boolean hasText(String value) {
		return value != null && !value.trim().isEmpty();
	}

	@Override
	public List<LandTransaction> findData(String district, String circle) {
		//log.info("findData");
		return repository.findByDistrictAndCircle(district, circle);
	}

	@Override
	public List<LandTransaction> findData(String district, String circle, String mouza) {
		// TODO Auto-generated method stub
		return repository.findByDistrictAndCircleAndMouza(district, circle, mouza);
	}
}
