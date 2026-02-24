package com.areap2.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import com.areap2.model.LandAreaRequest;

@Component
public class LandAreaExcelHelper {

	public LandAreaRequest mapRow(Row row) {

		LandAreaRequest req = new LandAreaRequest();

		req.setArea(getString(row, 0));
		req.setDistName(getString(row, 1));
		req.setRevenueCircle(getString(row, 2));
		req.setVillageName(getString(row, 3));
		req.setMouzaName(getString(row, 4));
		req.setAreaType(getString(row, 5));
		req.setLotNumber(getString(row, 6));
		req.setDagNInt(getString(row, 7));
		req.setDistFromCBD(getDouble(row, 8));
		req.setTypeOfCBD(getString(row, 9));
		req.setRoadFid(getString(row, 10));
		req.setDistFromRoad(getDouble(row, 11));
		req.setTypeOfRoad(getString(row, 12));
		req.setDistFromTransport(getDouble(row, 13));
		req.setDistFromEducation(getDouble(row, 14));
		req.setDistFromRestrictedArea(getDouble(row, 15));
		req.setDistFromOilPipeline(getDouble(row, 16));
		req.setDistFromHeritage(getDouble(row, 17));
		req.setDistFromFloodProne(getDouble(row, 18));
		req.setElevation(getDouble(row, 19));

		return req;
	}

	// ================= HELPER METHODS =================

	private String getString(Row row, int index) {

		Cell cell = row.getCell(index);
		if (cell == null)
			return null;

		if (cell.getCellType() == CellType.STRING) {
			return cell.getStringCellValue().trim();
		}

		if (cell.getCellType() == CellType.NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		}

		return cell.toString().trim();
	}

	private Double getDouble(Row row, int index) {

		Cell cell = row.getCell(index);
		if (cell == null)
			return null;

		try {
			if (cell.getCellType() == CellType.NUMERIC) {
				return cell.getNumericCellValue();
			}

			if (cell.getCellType() == CellType.STRING) {
				String value = cell.getStringCellValue().trim();
				return value.isEmpty() ? null : Double.parseDouble(value);
			}
		} catch (Exception e) {
			return null; // safe fallback for bad data
		}

		return null;
	}
}
