package com.areap2.controller.excel.map.util;

import java.util.ArrayList;
import java.util.List;

public class CellData {

	private final List<String> cells = new ArrayList<>();

	public void add(String value) {

		cells.add(value);

	}

	public String get(int index) {

		if (index >= cells.size())
			return "";

		String value = cells.get(index);

		return value == null ? "" : value;

	}

	public int size() {

		return cells.size();

	}

	public void clear() {

		cells.clear();

	}

}