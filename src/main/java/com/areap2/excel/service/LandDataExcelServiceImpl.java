package com.areap2.excel.service;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.areap2.excel.entity.LandDataExcel;
import com.areap2.excel.repository.LandDataExcelRepository;

import jakarta.persistence.EntityManager;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LandDataExcelServiceImpl implements LandDataExcelService {

	@Autowired
	private LandDataExcelRepository repository;

	@Autowired
	private EntityManager entityManager;

	@Transactional
	public void readExcel(String filePath) {

		int batchSize = 1000;
		int count = 0;

		List<LandDataExcel> batchList = new ArrayList<>(batchSize);

		try (FileInputStream fis = new FileInputStream(filePath); Workbook workbook = WorkbookFactory.create(fis)) {

			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();

			// Skip header
			if (rows.hasNext()) {
				rows.next();
			}

			while (rows.hasNext()) {

				Row row = rows.next();
				LandDataExcel data = new LandDataExcel();

				data.setGmLayer(getString(row.getCell(0)));
				data.setGmType(getString(row.getCell(1)));
				data.setObjectid(getBigDecimal(row.getCell(2)));
				data.setTextparcel(getBigDecimal(row.getCell(3)));
				data.setVillage(getString(row.getCell(4)));
				data.setMouza(getString(row.getCell(5)));
				data.setDistrict(getString(row.getCell(6)));
				data.setType(getString(row.getCell(7)));
				data.setArea(getBigDecimal(row.getCell(8)));
				data.setNicCode(getBigDecimal(row.getCell(9)));
				data.setNicVill(getBigDecimal(row.getCell(10)));
				data.setCircle(getString(row.getCell(11)));
				data.setShapeLeng(getBigDecimal(row.getCell(12)));
				data.setShapeArea(getBigDecimal(row.getCell(13)));
				data.setFid2(getBigDecimal(row.getCell(14)));
				data.setFid1(getBigDecimal(row.getCell(15)));
				data.setOrigFid(getBigDecimal(row.getCell(16)));
				data.setFidPwd(getBigDecimal(row.getCell(17)));
				data.setDistPwd(getBigDecimal(row.getCell(18)));
				data.setFidTr(getBigDecimal(row.getCell(19)));
				data.setDistTr(getBigDecimal(row.getCell(20)));
				data.setFidEdu(getBigDecimal(row.getCell(21)));
				data.setDistEdu(getBigDecimal(row.getCell(22)));
				data.setFidBrkl(getBigDecimal(row.getCell(23)));
				data.setDistBrkl(getBigDecimal(row.getCell(24)));
				data.setFidCnal(getBigDecimal(row.getCell(25)));
				data.setDistCnal(getBigDecimal(row.getCell(26)));
				data.setFidCntBt(getBigDecimal(row.getCell(27)));
				data.setDistCntBt(getBigDecimal(row.getCell(28)));
				data.setFidDstPa(getBigDecimal(row.getCell(29)));
				data.setDistDstPa(getBigDecimal(row.getCell(30)));
				data.setFidHliPa(getBigDecimal(row.getCell(31)));
				data.setDistHliPa(getBigDecimal(row.getCell(32)));
				data.setFidPrk(getBigDecimal(row.getCell(33)));
				data.setDistPrk(getBigDecimal(row.getCell(34)));
				data.setFidSwgPl(getBigDecimal(row.getCell(35)));
				data.setDisSwgPl(getBigDecimal(row.getCell(36)));
				data.setFidWlPrk(getBigDecimal(row.getCell(37)));
				data.setDisWlPrk(getBigDecimal(row.getCell(38)));
				data.setDRlCbd(getBigDecimal(row.getCell(39)));
				data.setTypeOfCbd(getString(row.getCell(40)));

				batchList.add(data);
				count++;

				if (count % batchSize == 0) {

					repository.saveAll(batchList);
					repository.flush();
					entityManager.clear();
					batchList.clear();

					System.out.println("Inserted: " + count);
				}
			}

			if (!batchList.isEmpty()) {
				repository.saveAll(batchList);
				repository.flush();
				entityManager.clear();
			}

			System.out.println("TOTAL INSERTED: " + count);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Excel Import Failed", e);
		}
	}

	private String getString(Cell cell) {
		if (cell == null)
			return null;
		return cell.toString().trim();
	}

	private BigDecimal getBigDecimal(Cell cell) {
		if (cell == null)
			return null;
		try {
			if (cell.getCellType() == CellType.NUMERIC) {
				return BigDecimal.valueOf(cell.getNumericCellValue());
			}
			return new BigDecimal(cell.toString().trim());
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Page<LandDataExcel> getLandDataByDistrict(String district, int page, int size) {

		log.info("Fetching land data for district: {}", district);

		Pageable pageable = PageRequest.of(page, size);

		Page<LandDataExcel> result = repository.findByDistrictIgnoreCase(district, pageable);

		log.info("Total records found: {}", result.getTotalElements());

		return result;
	}
}