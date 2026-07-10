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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.areap2.entity.excel.external.GeographicalFactorEntity;
import com.areap2.repository.excel.external.GeographicalFactorRepository;

@Service
public class GeographicalFactorService {

	@Autowired
	private GeographicalFactorRepository repository;

	// CREATE
	public GeographicalFactorEntity save(GeographicalFactorEntity entity) {
		return repository.save(entity);
	}

	// READ ALL
	public List<GeographicalFactorEntity> getAll() {
		return repository.findAll();
	}

	// READ BY ID
	public GeographicalFactorEntity getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));
	}

	// UPDATE
	public GeographicalFactorEntity update(Long id, GeographicalFactorEntity newData) {
		GeographicalFactorEntity existing = getById(id);

		existing.setMouza(newData.getMouza());
		existing.setNicCodeForMouza(newData.getNicCodeForMouza());
		existing.setRuralUrban(newData.getRuralUrban());
		existing.setFactor(newData.getFactor());

		return repository.save(existing);
	}

	// DELETE
	public void delete(Long id) {
		repository.deleteById(id);
	}

	// EXCEL
	public void uploadExcel(MultipartFile file) {

		try (InputStream is = file.getInputStream()) {

			Workbook workbook = WorkbookFactory.create(is);
			Sheet sheet = workbook.getSheetAt(0);

			List<GeographicalFactorEntity> list = new ArrayList<>();

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				String mouza = getStringValue(row.getCell(0));
				String nicCode = getStringValue(row.getCell(1));
				String ruralUrban = getStringValue(row.getCell(2));
				String factorStr = getStringValue(row.getCell(3));

				Double factor = null;
				if (factorStr != null && !factorStr.isEmpty()) {
					factor = Double.parseDouble(factorStr);
				}

				// ✅ Duplicate check (mouza + R/U)
				Optional<GeographicalFactorEntity> existing = repository.findByMouzaAndRuralUrban(mouza, ruralUrban);

				if (existing.isPresent()) {
					GeographicalFactorEntity update = existing.get();
					update.setNicCodeForMouza(nicCode);
					update.setFactor(factor);
					list.add(update);
				} else {
					GeographicalFactorEntity entity = new GeographicalFactorEntity();
					entity.setMouza(mouza);
					entity.setNicCodeForMouza(nicCode);
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
			return String.valueOf((long) cell.getNumericCellValue());
		}

		return cell.getStringCellValue().trim();
	}
}
