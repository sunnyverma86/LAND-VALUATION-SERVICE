package com.areap2.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.areap2.entity.excel.external.LandDataXlsPropertyMeasurement;
import com.areap2.entity.excel.external.LandDataXlsPropertyOriginal;
import com.areap2.repository.excel.external.LandDataXlsPropertyMeasurementRepository;
import com.areap2.repository.excel.external.LandDataXlsPropertyOriginalRepository;

import jakarta.transaction.Transactional;

@Service
public class LandDataXlsPropertyOriginalPhaseOneService {

	private static final Logger log = LoggerFactory.getLogger(LandDataXlsPropertyOriginalPhaseOneService.class);

	private static final int PAGE_SIZE = 5000;

	@Autowired
	private LandDataXlsPropertyMeasurementRepository measurementRepository;

	@Autowired
	private LandDataXlsPropertyOriginalRepository originalRepository;

	@Transactional
	public void migrateData() {

		log.info("Land Data Migration Started");

		int pageNumber = 0;
		long totalProcessed = 0;

		try {

			Page<LandDataXlsPropertyMeasurement> page;

			do {

				Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);
				page = measurementRepository.findAll(pageable);

				List<LandDataXlsPropertyOriginal> batchList = new ArrayList<>();

				for (LandDataXlsPropertyMeasurement src : page.getContent()) {

					try {

						LandDataXlsPropertyOriginal dest = transform(src);

						if (dest != null) {
							batchList.add(dest);
						}

					} catch (Exception e) {

						log.error("Error processing NIC Code: {}", src.getNiccode(), e);
					}
				}

				if (!batchList.isEmpty()) {

					originalRepository.saveAll(batchList);

					totalProcessed += batchList.size();

					log.info("Batch saved. Records processed so far: {}", totalProcessed);
				}

				pageNumber++;

			} while (page.hasNext());

			log.info("Land Data Migration Completed. Total Records Inserted: {}", totalProcessed);

		} catch (Exception e) {

			log.error("Migration failed due to unexpected error", e);

			throw new RuntimeException("Land data migration failed", e);
		}
	}

	/**
	 * Convert source entity to destination entity
	 */
	private LandDataXlsPropertyOriginal transform(LandDataXlsPropertyMeasurement src) {

		String nic = src.getNiccode();

		if (nic == null || nic.length() < 14) {

			log.warn("Invalid NIC code found: {}", nic);
			return null;
		}

		LandDataXlsPropertyOriginal dest = new LandDataXlsPropertyOriginal();

		dest.setNiccode(nic);
		dest.setTextparcel(src.getTextparcel());
		dest.setLandArea(src.getLandArea());
		dest.setRuralUrban(src.getRuralUrban());

		try {

			dest.setVillageCode(nic.substring(nic.length() - 5));
			dest.setLotCode(nic.substring(nic.length() - 7, nic.length() - 5));
			dest.setMouzaCode(nic.substring(nic.length() - 9, nic.length() - 7));
			dest.setCircleCode(nic.substring(nic.length() - 11, nic.length() - 9));
			dest.setSubDivisionCode(nic.substring(nic.length() - 13, nic.length() - 11));
			dest.setDistrictCode(nic.substring(0, nic.length() - 13));

		} catch (Exception e) {

			log.error("Error extracting codes from NIC: {}", nic, e);
			return null;
		}

		dest.setCreatedBy("SYSTEM");
		dest.setUpdatedBy("SYSTEM");
		dest.setCreateDtm(LocalDateTime.now());
		dest.setUpdateDtm(LocalDateTime.now());
		dest.setStatus("ACTIVE");

		return dest;
	}
}