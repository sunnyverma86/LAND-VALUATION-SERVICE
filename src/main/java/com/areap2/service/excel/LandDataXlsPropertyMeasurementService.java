package com.areap2.service.excel;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParserFactory;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStrings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.Attributes;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.areap2.entity.excel.external.LandDataXlsPropertyMeasurement;
import com.areap2.repository.excel.external.LandDataXlsPropertyMeasurementRepository;

@Service
public class LandDataXlsPropertyMeasurementService {

    @Autowired
    private LandDataXlsPropertyMeasurementRepository repository;

    private static final int BATCH_SIZE = 5000;

    public void processExcel(String filePath) {

        System.out.println("Starting Excel import: " + filePath);

        List<LandDataXlsPropertyMeasurement> batch = new ArrayList<>();

        try {

            OPCPackage opcPackage = OPCPackage.open(new File(filePath));
            XSSFReader reader = new XSSFReader(opcPackage);

            SharedStrings sst = reader.getSharedStringsTable();
            InputStream sheetStream = reader.getSheetsData().next();

            XMLReader parser = SAXParserFactory.newInstance()
                    .newSAXParser()
                    .getXMLReader();

            parser.setContentHandler(new DefaultHandler() {

                private String lastValue = "";
                private boolean nextIsString = false;

                private int columnIndex = -1;
                private int rowIndex = 0;

                private List<String> rowValues = new ArrayList<>();

                @Override
                public void startElement(String uri, String localName, String name, Attributes attributes) {

                    if ("c".equals(name)) {

                        String cellType = attributes.getValue("t");
                        nextIsString = "s".equals(cellType);

                        String cellRef = attributes.getValue("r");

                        if (cellRef != null) {
                            columnIndex = cellRef.replaceAll("[0-9]", "").charAt(0) - 'A';
                        }
                    }

                    lastValue = "";
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    lastValue += new String(ch, start, length);
                }

                @Override
                public void endElement(String uri, String localName, String name) {

                    if (nextIsString) {
                        int idx = Integer.parseInt(lastValue);
                        lastValue = sst.getItemAt(idx).getString();
                        nextIsString = false;
                    }

                    if ("v".equals(name)) {

                        while (rowValues.size() <= columnIndex) {
                            rowValues.add("");
                        }

                        rowValues.set(columnIndex, lastValue);
                    }

                    if ("row".equals(name)) {

                        // Skip header row
                        if (rowIndex == 0) {
                            rowIndex++;
                            rowValues.clear();
                            return;
                        }

                        LandDataXlsPropertyMeasurement data = new LandDataXlsPropertyMeasurement();

                        data.setDist(getValue(0));
                        data.setCircle(getValue(1));
                        data.setMouza(getValue(2));
                        data.setLot(getValue(3));
                        data.setVillage(getValue(4));
                        data.setTextparcel(getValue(5));
                        data.setLanduse(getValue(6));
                        data.setZonalValue(parseDouble(getValue(7)));
                        data.setLandArea(getValue(8));   // <-- FIX
                        data.setDagRevenue(getValue(9));
                        data.setDagLocalTax(getValue(10));
                        data.setRuralUrban(getValue(11));
                        data.setNiccode(getValue(12));

                        batch.add(data);

                        if (batch.size() == BATCH_SIZE) {

                            repository.saveAll(batch);
                            repository.flush();
                            batch.clear();

                            System.out.println("Inserted rows: " + rowIndex);
                        }

                        rowIndex++;
                        rowValues.clear();
                    }
                }

                private String getValue(int index) {

                    if (index >= rowValues.size()) {
                        return null;
                    }

                    return rowValues.get(index);
                }

                private Double parseDouble(String value) {

                    try {

                        if (value == null || value.trim().isEmpty()) {
                            return null;
                        }

                        // Remove quotes from Excel value
                        value = value.replace("\"", "").trim();

                        return Double.parseDouble(value);

                    } catch (Exception e) {

                        return null;
                    }
                }

            });

            parser.parse(new org.xml.sax.InputSource(sheetStream));

            if (!batch.isEmpty()) {
                repository.saveAll(batch);
                repository.flush();
            }

            sheetStream.close();
            opcPackage.close();

            System.out.println("Excel import completed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}