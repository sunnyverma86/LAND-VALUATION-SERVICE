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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.apache.poi.util.IOUtils;

import com.areap2.controller.excel.map.repo.LandDetailsInputRepository;

@Service
public class LandDetailsInputService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LandDetailsInputService.class);

	@Autowired
	private LandDetailsInputRepository repository;

	public long upload(MultipartFile file) {
		IOUtils.setByteArrayMaxOverride(300_000_000);
		validateFile(file);

		logMemoryUsage();

		long startTime = System.currentTimeMillis();

		AtomicLong totalRecords = new AtomicLong();

		LOGGER.info("==========================================");
		LOGGER.info("Land Details Excel Upload Started");
		LOGGER.info("File Name : {}", file.getOriginalFilename());
		LOGGER.info("==========================================");

		try (OPCPackage opcPackage = OPCPackage.open(file.getInputStream())) {

			ReadOnlySharedStringsTable sharedStrings = new ReadOnlySharedStringsTable(opcPackage);

			XSSFReader reader = new XSSFReader(opcPackage);

			StylesTable styles = reader.getStylesTable();

			XSSFReader.SheetIterator sheetIterator = (XSSFReader.SheetIterator) reader.getSheetsData();

			while (sheetIterator.hasNext()) {

				try (InputStream sheetStream = sheetIterator.next()) {

					LOGGER.info("Processing Sheet : {}", sheetIterator.getSheetName());

					SAXParserFactory factory = SAXParserFactory.newInstance();

					factory.setNamespaceAware(true);
					factory.setValidating(false);

					XMLReader parser = factory.newSAXParser().getXMLReader();

					DataFormatter formatter = new DataFormatter();

					LandDetailsSheetHandler handler = new LandDetailsSheetHandler(repository, totalRecords);

					XSSFSheetXMLHandler sheetHandler = new XSSFSheetXMLHandler(styles, sharedStrings, handler,
							formatter, false);

					parser.setContentHandler(sheetHandler);

					parser.parse(new InputSource(sheetStream));

					handler.flushRemainingBatches();

					LOGGER.info("Sheet Completed.");
				}
			}

		} catch (Exception ex) {

			LOGGER.error("Excel Upload Failed", ex);

			throw new RuntimeException(ex);

		} finally {

			performGarbageCollection();

			logMemoryUsage();
		}

		long endTime = System.currentTimeMillis();

		LOGGER.info("==========================================");
		LOGGER.info("Upload Completed");
		LOGGER.info("Total Records : {}", totalRecords.get());
		LOGGER.info("Execution Time : {} Seconds", (endTime - startTime) / 1000);
		LOGGER.info("==========================================");

		return totalRecords.get();
	}

	private void validateFile(MultipartFile file) {

		if (file == null)
			throw new IllegalArgumentException("File is null.");

		if (file.isEmpty())
			throw new IllegalArgumentException("Uploaded file is empty.");

		String fileName = file.getOriginalFilename();

		if (fileName == null || !fileName.toLowerCase().endsWith(".xlsx"))
			throw new IllegalArgumentException("Only .xlsx files are supported.");
	}

	private void logMemoryUsage() {

		Runtime runtime = Runtime.getRuntime();

		long total = runtime.totalMemory() / (1024 * 1024);

		long free = runtime.freeMemory() / (1024 * 1024);

		long used = total - free;

		LOGGER.info("Heap Used : {} MB", used);
	}

	private void performGarbageCollection() {

		System.gc();
	}

}