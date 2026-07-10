package com.areap2.controller.excel.map.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;

import com.areap2.controller.excel.map.enity.LandDetailsInputEntity;
import com.areap2.controller.excel.map.repo.LandDetailsInputRepository;

public class LandDetailsSheetHandler implements XSSFSheetXMLHandler.SheetContentsHandler {

	private static final int BATCH_SIZE = 1000;

	private final List<LandDetailsInputEntity> batch = new ArrayList<>();

	private final LandDetailsInputRepository repository;

	private final AtomicLong totalRecords;

	private LandDetailsInputEntity entity;

	private int currentColumn = -1;

	private int currentRow = -1;

	public LandDetailsSheetHandler(LandDetailsInputRepository repository, AtomicLong totalRecords) {

		this.repository = repository;
		this.totalRecords = totalRecords;
	}

	@Override
	public void startRow(int rowNum) {

		currentRow = rowNum;

		if (rowNum > 1) { // Skip blank row + header row
			entity = new LandDetailsInputEntity();
		}
	}

	@Override
	public void endRow(int rowNum) {

		if (rowNum <= 1)
			return;

		batch.add(entity);

		totalRecords.incrementAndGet();

		if (batch.size() >= BATCH_SIZE) {
			repository.saveAll(batch);
			batch.clear();
		}
	}

	@Override
	public void cell(String cellReference, String formattedValue, org.apache.poi.xssf.usermodel.XSSFComment comment) {

		if (currentRow <= 1)
			return;

		currentColumn = new org.apache.poi.ss.util.CellReference(cellReference).getCol();

		switch (currentColumn) {

		case 0:
			entity.setDist(formattedValue);
			break;

		case 1:
			entity.setCircle(formattedValue);
			break;

		case 2:
			entity.setMouza(formattedValue);
			break;

		case 3:
			entity.setLot(formattedValue);
			break;

		case 4:
			entity.setVillage(formattedValue);
			break;

		case 5:
			entity.setTextparcel(formattedValue);
			break;

		case 6:
			entity.setLanduse(formattedValue);
			break;

		case 7:
			entity.setLanduseEnglish(formattedValue);
			break;

		case 8:
			entity.setCategory(formattedValue);
			break;

		case 9:
			entity.setZonalValue(parseDouble(formattedValue));
			break;

		case 10:
			entity.setDagRevenue(parseDouble(formattedValue));
			break;

		case 11:
			entity.setDagLocalTax(parseDouble(formattedValue));
			break;

		case 12:
			entity.setTotalRevenue(parseDouble(formattedValue));
			break;

		case 13:
			entity.setRuralUrban(formattedValue);
			break;

		case 14:
			entity.setNiccode(formattedValue);
			break;

		case 15:
			entity.setLandArea(formattedValue);
			break;
		}
	}

	private Double parseDouble(String value) {

		try {
			return value == null || value.isBlank() ? 0.0 : Double.parseDouble(value);
		} catch (Exception e) {
			return 0.0;
		}
	}

	public void flushRemainingBatches() {

		if (!batch.isEmpty()) {
			repository.saveAll(batch);
			batch.clear();
		}
	}
}