package com.areap2.controller.excel.map.util;

import java.math.BigDecimal;

import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Component;

@Component
public class ExcelUtil {
	
	
	public String getCellValue(Cell cell) {

		if (cell == null) {
			return "";
		}

		try {

			switch (cell.getCellType()) {

			case STRING:
				return cell.getStringCellValue().trim();

			case NUMERIC:
				return BigDecimal.valueOf(cell.getNumericCellValue()).stripTrailingZeros().toPlainString();

			case BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());

			case FORMULA:

				switch (cell.getCachedFormulaResultType()) {

				case STRING:
					return cell.getStringCellValue().trim();

				case NUMERIC:
					return BigDecimal.valueOf(cell.getNumericCellValue()).stripTrailingZeros().toPlainString();

				case BOOLEAN:
					return String.valueOf(cell.getBooleanCellValue());

				default:
					return "";
				}

			default:
				return "";
			}

		} catch (Exception e) {
			return "";
		}
	}


	public String getCellValueOld(Cell cell) {

		if (cell == null)
			return "";

		return switch (cell.getCellType()) {

		case STRING -> cell.getStringCellValue().trim();

		case NUMERIC -> BigDecimal.valueOf(cell.getNumericCellValue()).stripTrailingZeros().toPlainString();

		case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());

		default -> "";
		};
	}

	public BigDecimal parseDecimal(String value) {

		try {

			if (value == null || value.isBlank())
				return null;

			value = value.replace(",", "").trim();

			return new BigDecimal(value);

		} catch (Exception e) {

			return null;
		}
	}
}
