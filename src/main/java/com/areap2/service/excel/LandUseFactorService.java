package com.areap2.service.excel;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.areap2.entity.excel.external.LandUseFactorEntity;
import com.areap2.repository.excel.external.LandUseFactorRepository;

@Service
public class LandUseFactorService {

	private final LandUseFactorRepository repository;

	public LandUseFactorService(LandUseFactorRepository repository) {
		this.repository = repository;
	}

	// CREATE
	public LandUseFactorEntity save(LandUseFactorEntity entity) {
		return repository.save(entity);
	}

	// READ ALL
	public List<LandUseFactorEntity> getAll() {
		return repository.findAll();
	}

	// READ BY ID
	public LandUseFactorEntity getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));
	}

	// UPDATE
	public LandUseFactorEntity update(Long id, LandUseFactorEntity newData) {
		LandUseFactorEntity existing = getById(id);

		existing.setLandUse(newData.getLandUse());
		existing.setRuralUrban(newData.getRuralUrban());
		existing.setFactor(newData.getFactor());

		return repository.save(existing);
	}

	// DELETE
	public void delete(Long id) {
		repository.deleteById(id);
	}

	// Excel
	public void uploadExcel(MultipartFile file) {

		try (InputStream is = file.getInputStream()) {

			Workbook workbook = WorkbookFactory.create(is);
			Sheet sheet = workbook.getSheetAt(0);

			List<LandUseFactorEntity> list = new ArrayList<>();

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				String landUse = getStringValue(row.getCell(0));
				String ruralUrban = getStringValue(row.getCell(1));
				String factorStr = getStringValue(row.getCell(2));

				Double factor = null;

				if (factorStr != null && !factorStr.isEmpty()) {
					factor = Double.parseDouble(factorStr);
				}

				// ✅ Duplicate check
				Optional<LandUseFactorEntity> existing = repository.findByLandUseAndRuralUrban(landUse, ruralUrban);

				if (existing.isPresent()) {
					LandUseFactorEntity update = existing.get();
					update.setFactor(factor);
					list.add(update);
				} else {
					LandUseFactorEntity entity = new LandUseFactorEntity();
					entity.setLandUse(landUse);
					entity.setRuralUrban(ruralUrban);
					entity.setFactor(factor);
					list.add(entity);
				}
			}

			repository.saveAll(list);

		} catch (Exception e) {
			throw new RuntimeException("Excel upload failed: " + e.getMessage());
		}
	}

	private String getStringValue(Cell cell) {
		if (cell == null)
			return null;

		if (cell.getCellType() == CellType.NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		}

		return cell.getStringCellValue().trim();
	}
}
