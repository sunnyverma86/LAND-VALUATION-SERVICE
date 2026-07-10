package com.areap2.controller.excel.map.service;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

import javax.xml.parsers.SAXParserFactory;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.eventusermodel.ReadOnlySharedStringsTable;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.model.StylesTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.areap2.controller.excel.map.repo.LandBatchRepository;
import com.areap2.controller.excel.map.repo.LufBatchRepository;
import com.areap2.controller.excel.map.repo.MouzaFactorBaseDatabaseRepository;
import com.areap2.controller.excel.map.repo.VfBatchRepository;
import com.areap2.controller.excel.map.util.ExcelUtil;
import com.areap2.controller.excel.map.util.SheetType;

@Service
public class ExcelUploadService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUploadService.class);

	private final ExcelUtil excelUtil;

	private final LandBatchRepository landRepository;

	private final LufBatchRepository lufRepository;

	private final VfBatchRepository vfRepository;

	private final MouzaFactorBaseDatabaseRepository mfRepository;

	public ExcelUploadService(ExcelUtil excelUtil, LandBatchRepository landRepository, LufBatchRepository lufRepository,
			VfBatchRepository vfRepository, MouzaFactorBaseDatabaseRepository mfRepository) {

		this.excelUtil = excelUtil;
		this.landRepository = landRepository;
		this.lufRepository = lufRepository;
		this.vfRepository = vfRepository;
		this.mfRepository = mfRepository;
	}

	public long upload(MultipartFile file) {

		validateFile(file);

		logMemoryUsage();

		long startTime = System.currentTimeMillis();

		AtomicLong totalRecords = new AtomicLong();

		LOGGER.info("==========================================");
		LOGGER.info("Excel Upload Started");
		LOGGER.info("File Name : {}", file.getOriginalFilename());
		LOGGER.info("File Size : {} MB", String.format("%.2f", file.getSize() / (1024d * 1024d)));
		LOGGER.info("==========================================");

		try (OPCPackage opcPackage = OPCPackage.open(file.getInputStream())) {

			ReadOnlySharedStringsTable sharedStrings = new ReadOnlySharedStringsTable(opcPackage);

			XSSFReader reader = new XSSFReader(opcPackage);

			StylesTable styles = reader.getStylesTable();

			XSSFReader.SheetIterator sheetIterator = (XSSFReader.SheetIterator) reader.getSheetsData();

			while (sheetIterator.hasNext()) {

				try (InputStream sheetStream = sheetIterator.next()) {

					String sheetName = sheetIterator.getSheetName();

					LOGGER.info("------------------------------------------------");
					LOGGER.info("Processing Sheet : {}", sheetName);
					LOGGER.info("------------------------------------------------");

					SheetType sheetType;

					switch (sheetName.trim().toUpperCase()) {

					case "DATA BASE":
						sheetType = SheetType.DATABASE;
						break;

					case "LUF":
						sheetType = SheetType.LUF;
						break;

					case "VF":
						sheetType = SheetType.VF;
						break;

					case "MF":
						sheetType = SheetType.MF;
						break;

					default:

						LOGGER.warn("Unknown Sheet [{}] skipped.", sheetName);

						continue;
					}
					SAXParserFactory factory = SAXParserFactory.newInstance();

					factory.setNamespaceAware(true);

					factory.setValidating(false);

					XMLReader parser = factory.newSAXParser().getXMLReader();
					ExcelSheetHandler handler = new ExcelSheetHandler(sheetType, totalRecords, excelUtil,
							landRepository, lufRepository, vfRepository, mfRepository);

					DataFormatter formatter = new DataFormatter();

					XSSFSheetXMLHandler sheetHandler = new XSSFSheetXMLHandler(styles, sharedStrings, handler,
							formatter, false);

					parser.setContentHandler(sheetHandler);

					parser.parse(new InputSource(sheetStream));

					/*
					 * VERY IMPORTANT Save remaining records which are less than batch size.
					 */
					handler.flushRemainingBatches();

					LOGGER.info("Sheet [{}] Completed.", sheetName);
				}
			}
		} catch (Exception ex) {

			LOGGER.error("==========================================");
			LOGGER.error("Excel Upload Failed");
			LOGGER.error("Reason : {}", ex.getMessage(), ex);
			LOGGER.error("==========================================");

			throw new RuntimeException("Excel Upload Failed : " + ex.getMessage(), ex);

		} finally {

			performGarbageCollection();

			logMemoryUsage();

			LOGGER.info("Upload Resources Released.");
		}

		long endTime = System.currentTimeMillis();

		LOGGER.info("==========================================");
		LOGGER.info("Excel Upload Completed Successfully");
		LOGGER.info("Total Records Processed : {}", totalRecords.get());
		LOGGER.info("Execution Time : {} Seconds", (endTime - startTime) / 1000);
		LOGGER.info("==========================================");

		return totalRecords.get();
	}

	/**
	 * Validate uploaded file.
	 */
	private void validateFile(MultipartFile file) {

		if (file == null) {
			throw new IllegalArgumentException("File cannot be null.");
		}

		if (file.isEmpty()) {
			throw new IllegalArgumentException("Uploaded file is empty.");
		}

		String fileName = file.getOriginalFilename();

		if (fileName == null || fileName.isBlank()) {
			throw new IllegalArgumentException("Invalid file name.");
		}

		if (!fileName.toLowerCase().endsWith(".xlsx")) {
			throw new IllegalArgumentException("Only .xlsx files are supported.");
		}

		LOGGER.info("File Validation Successful");
	}

	/**
	 * Print JVM heap usage.
	 */
	private void logMemoryUsage() {

		Runtime runtime = Runtime.getRuntime();

		long max = runtime.maxMemory() / (1024 * 1024);

		long total = runtime.totalMemory() / (1024 * 1024);

		long free = runtime.freeMemory() / (1024 * 1024);

		long used = total - free;

		LOGGER.info("============== JVM MEMORY ==============");
		LOGGER.info("Max Heap   : {} MB", max);
		LOGGER.info("Total Heap : {} MB", total);
		LOGGER.info("Used Heap  : {} MB", used);
		LOGGER.info("Free Heap  : {} MB", free);
		LOGGER.info("========================================");
	}

	/**
	 * Request Garbage Collection.
	 */
	private void performGarbageCollection() {

		System.gc();

		LOGGER.debug("Garbage Collection Requested.");
	}

}
