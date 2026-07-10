package com.areap2.controller.excel.map.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler.SheetContentsHandler;
import org.apache.poi.xssf.usermodel.XSSFComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.areap2.controller.excel.map.enity.LandRecordEntity;
import com.areap2.controller.excel.map.enity.LandUseFactorExcelEntity;
import com.areap2.controller.excel.map.enity.MouzaFactorBaseDatabase;
import com.areap2.controller.excel.map.enity.VillageLandClassEntity;
import com.areap2.controller.excel.map.repo.LandBatchRepository;
import com.areap2.controller.excel.map.repo.LufBatchRepository;
import com.areap2.controller.excel.map.repo.MouzaFactorBaseDatabaseRepository;
import com.areap2.controller.excel.map.repo.VfBatchRepository;
import com.areap2.controller.excel.map.util.CellData;
import com.areap2.controller.excel.map.util.ExcelConstants;
import com.areap2.controller.excel.map.util.ExcelUtil;
import com.areap2.controller.excel.map.util.SheetType;

public class ExcelSheetHandler implements SheetContentsHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelSheetHandler.class);

	/*
	 * Current Sheet
	 */
	private final SheetType sheetType;

	/*
	 * Total Uploaded Records
	 */
	private final AtomicLong totalRecords;

	/*
	 * Utility
	 */
	private final ExcelUtil excelUtil;

	/*
	 * Jdbc Batch Repositories
	 */
	private final LandBatchRepository landRepository;

	private final LufBatchRepository lufRepository;

	private final VfBatchRepository vfRepository;

	private final MouzaFactorBaseDatabaseRepository mfRepository;

	/*
	 * Current Row Values
	 */
	private final CellData rowData = new CellData();

	/*
	 * Row Number
	 */
	private int currentRow = 0;

	/*
	 * Current Column
	 */
	private int currentColumn = -1;

	/*
	 * Batch Lists
	 */
	private final List<LandRecordEntity> landBatch = new ArrayList<>(ExcelConstants.BATCH_SIZE);

	private final List<LandUseFactorExcelEntity> lufBatch = new ArrayList<>(ExcelConstants.BATCH_SIZE);

	private final List<VillageLandClassEntity> vfBatch = new ArrayList<>(ExcelConstants.BATCH_SIZE);

	private final List<MouzaFactorBaseDatabase> mfBatch = new ArrayList<>(ExcelConstants.BATCH_SIZE);

	/*
	 * Constructor
	 */
	public ExcelSheetHandler(

			SheetType sheetType,

			AtomicLong totalRecords,

			ExcelUtil excelUtil,

			LandBatchRepository landRepository,

			LufBatchRepository lufRepository,

			VfBatchRepository vfRepository,

			MouzaFactorBaseDatabaseRepository mfRepository) {

		this.sheetType = sheetType;

		this.totalRecords = totalRecords;

		this.excelUtil = excelUtil;

		this.landRepository = landRepository;

		this.lufRepository = lufRepository;

		this.vfRepository = vfRepository;

		this.mfRepository = mfRepository;
	}

	/*
	 * ========================== SAX CALLBACKS START HERE
	 * ==========================
	 */

	@Override
	public void startRow(int rowNum) {

		currentRow = rowNum;

		currentColumn = -1;

		rowData.clear();

	}

	@Override
	public void cell(String cellReference, String formattedValue, XSSFComment comment) {

		if (cellReference == null) {
			return;
		}

		int column = new CellReference(cellReference).getCol();

		/*
		 * Fill Missing Cells
		 *
		 * Example: A1 C1
		 *
		 * Then B1 will be inserted automatically.
		 */

		while (currentColumn + 1 < column) {

			rowData.add("");

			currentColumn++;

		}

		rowData.add(formattedValue == null ? "" : formattedValue);

		currentColumn = column;

	}

	@Override
	public void endRow(int rowNum) {

		/*
		 * Skip Header
		 */
		if (rowNum == 0) {
			return;
		}

		try {

			switch (sheetType) {

			case DATABASE:

				landBatch.add(mapLand());

				if (landBatch.size() >= ExcelConstants.BATCH_SIZE) {

					saveLandBatch();

				}

				break;

			case LUF:

				lufBatch.add(mapLuf());

				if (lufBatch.size() >= ExcelConstants.BATCH_SIZE) {

					saveLufBatch();

				}

				break;

			case VF:

				vfBatch.add(mapVf());

				if (vfBatch.size() >= ExcelConstants.BATCH_SIZE) {

					saveVfBatch();

				}

				break;

			case MF:

				mfBatch.add(mapMf());

				if (mfBatch.size() >= ExcelConstants.BATCH_SIZE) {

					saveMfBatch();

				}

				break;

			default:

				break;

			}

			totalRecords.incrementAndGet();

			if (totalRecords.get() % 1000 == 0) {

				LOGGER.info("{} Records Processed", totalRecords.get());

			}

		} catch (Exception ex) {

			LOGGER.error("Error Processing Row : {}", currentRow, ex);

		}

	}

	@Override
	public void headerFooter(String text, boolean isHeader, String tagName) {

		// Not Required

	}
	/*
	 * ====================================================== Helper Methods
	 * ======================================================
	 */

	private String value(int index) {

		if (index >= rowData.size()) {
			return "";
		}

		String value = rowData.get(index);

		return value == null ? "" : value.trim();
	}

	private BigDecimal decimal(int index) {

		return excelUtil.parseDecimal(value(index));

	}

	/*
	 * ====================================================== Flush Remaining
	 * Records ======================================================
	 */

	public void flush() {

		saveLandBatch();

		saveLufBatch();

		saveVfBatch();

		saveMfBatch();

	}

	/*
	 * ====================================================== DATABASE Batch
	 * ======================================================
	 */

	private void saveLandBatch() {

		if (landBatch.isEmpty()) {
			return;
		}

		landRepository.saveBatch(landBatch);

		LOGGER.info("DATABASE Batch Saved : {}", landBatch.size());

		landBatch.clear();

	}

	/*
	 * ====================================================== LUF Batch
	 * ======================================================
	 */

	private void saveLufBatch() {

		if (lufBatch.isEmpty()) {
			return;
		}

		lufRepository.saveBatch(lufBatch);

		LOGGER.info("LUF Batch Saved : {}", lufBatch.size());

		lufBatch.clear();

	}

	/*
	 * ====================================================== VF Batch
	 * ======================================================
	 */

	private void saveVfBatch() {

		if (vfBatch.isEmpty()) {
			return;
		}

		vfRepository.saveBatch(vfBatch);

		LOGGER.info("VF Batch Saved : {}", vfBatch.size());

		vfBatch.clear();

	}

	/*
	 * ====================================================== MF Batch
	 * ======================================================
	 */

	private void saveMfBatch() {

		if (mfBatch.isEmpty()) {
			return;
		}

		mfRepository.saveBatch(mfBatch);

		LOGGER.info("MF Batch Saved : {}", mfBatch.size());

		mfBatch.clear();

	}

	/*
	 * ====================================================== DATABASE Mapping
	 * ======================================================
	 */
	private LandRecordEntity mapLand() {

		LandRecordEntity entity = new LandRecordEntity();

		entity.setMouza(value(0));
		entity.setVillage(value(1));
		entity.setZonalValue(decimal(2));
		entity.setRuralUrban(value(3));
		entity.setLandUse(value(4));
		entity.setNh(decimal(5));
		entity.setDistPwd(decimal(6));
		entity.setdMjcbd(decimal(7));
		entity.setdUrMncbd(decimal(8));
		entity.setDisWtrLg(value(9));
		entity.setOilPipeline(decimal(10));
		entity.setEcosensitive(decimal(11));
		entity.setNic(value(12));
		entity.setHelper(value(13));
		entity.setPlot(value(14));
		entity.setMouzaCode(value(15));
		entity.setHelperCode(value(16));
		entity.setDistrict(value(17));
		entity.setCircle(value(18));
		entity.setLot(value(19));

		return entity;
	}

	/*
	 * ====================================================== LUF Mapping
	 * ======================================================
	 */
	private LandUseFactorExcelEntity mapLuf() {

		LandUseFactorExcelEntity entity = new LandUseFactorExcelEntity();

		entity.setLandUse(value(1));
		entity.setRuralUrban(value(2));
		entity.setLuf(decimal(3));

		return entity;
	}

	/*
	 * ====================================================== VF Mapping
	 * ======================================================
	 */
	private VillageLandClassEntity mapVf() {

		VillageLandClassEntity entity = new VillageLandClassEntity();

		entity.setExcelId(value(0));
		entity.setVillage(value(1));
		entity.setRuralUrban(value(2));
		entity.setLandClass(value(3));
		entity.setMinWithoutOutliers(decimal(4));
		entity.setEquivalentMinimum(decimal(5));
		entity.setNameOfEquivalent(value(6));
		entity.setLuf(decimal(7));
		entity.setMinEquivalentValue(decimal(8));
		entity.setFinalMinEq(decimal(9));
		entity.setMouzaCode(value(10));
		entity.setUniqueId(value(11));
		entity.setMouzaName(value(12));
		entity.setMouzaMin(decimal(13));
		entity.setBandRatio(decimal(14));

		return entity;
	}

	/*
	 * ====================================================== MF Mapping
	 * ======================================================
	 */
	private MouzaFactorBaseDatabase mapMf() {

		MouzaFactorBaseDatabase entity = new MouzaFactorBaseDatabase();

		entity.setMouza(value(1));
		entity.setRuralUrban(value(2));
		entity.setLandUse(value(3));
		entity.setMinExcl(decimal(4));
		entity.setHigherLandClassMin(decimal(5));
		entity.setLc(decimal(6));
		entity.setLuf(decimal(7));
		entity.setDistrictMinimum(decimal(8));
		entity.setCurrent(decimal(9));
		entity.setFinalMfZonalValue(decimal(10));

		return entity;
	}

	public void flushRemainingBatches() {

		saveLandBatch();
		saveLufBatch();
		saveVfBatch();
		saveMfBatch();
	}
}