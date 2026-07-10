package com.areap2.service.excel;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.areap2.entity.excel.external.DistrictMinimumEntity;
import com.areap2.repository.excel.external.DistrictMinimumRepository;

@Service
public class MasterDistrictMinimumService {

	@Autowired
	private DistrictMinimumRepository repository;

	// CREATE
	public DistrictMinimumEntity save(DistrictMinimumEntity data) {
		return repository.save(data);
	}

	// READ ALL
	public List<DistrictMinimumEntity> getAll() {
		return repository.findAll();
	}

	// READ BY ID
	public DistrictMinimumEntity getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Data not found"));
	}

	// UPDATE
	public DistrictMinimumEntity update(Long id, DistrictMinimumEntity newData) {
		DistrictMinimumEntity existing = getById(id);

		existing.setDistrict(newData.getDistrict());
		existing.setNicCodeForDistrict(newData.getNicCodeForDistrict());
		existing.setRuralUrban(newData.getRuralUrban());
		existing.setDistrictMinimumValue(newData.getDistrictMinimumValue());

		return repository.save(existing);
	}

	// DELETE
	public void delete(Long id) {
		repository.deleteById(id);
	}

	// excel
	public void uploadExcel(MultipartFile file) {
		try (InputStream is = file.getInputStream()) {

			Workbook workbook = WorkbookFactory.create(is);
			Sheet sheet = workbook.getSheetAt(0);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {

				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				String district = getStringValue(row.getCell(0));
				String nicCode = getStringValue(row.getCell(1));
				String ruralUrban = getStringValue(row.getCell(2));
				String valueStr = getStringValue(row.getCell(3));

				BigDecimal value = null;

				if (valueStr != null && !valueStr.equals("-") && !valueStr.isEmpty()) {
					value = new BigDecimal(valueStr.replace(",", ""));
				}

				// ✅ Without builder
				DistrictMinimumEntity entity = new DistrictMinimumEntity();
				entity.setDistrict(district);
				entity.setNicCodeForDistrict(nicCode);
				entity.setRuralUrban(ruralUrban);
				entity.setDistrictMinimumValue(value);

				repository.save(entity);
			}

		} catch (Exception e) {
			throw new RuntimeException("Failed to upload Excel: " + e.getMessage());
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
