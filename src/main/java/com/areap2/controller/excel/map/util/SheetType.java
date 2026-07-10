package com.areap2.controller.excel.map.util;

public enum SheetType {

	DATABASE, LUF, VF, MF, UNKNOWN;

	public static SheetType fromSheetName(String sheetName) {

		if (sheetName == null)
			return UNKNOWN;

		switch (sheetName.trim().toUpperCase()) {

		case "DATA BASE":
			return DATABASE;

		case "LUF":
			return LUF;

		case "VF":
			return VF;

		case "MF":
			return MF;

		default:
			return UNKNOWN;
		}

	}

}