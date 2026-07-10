package com.areap2.controller.excel.map.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.areap2.controller.excel.map.bean.DistrictParameterRequest;
import com.areap2.controller.excel.map.enity.DistrictParameterMasterHistory;
import com.areap2.controller.excel.map.enity.band.DistrictParameterMaster;
import com.areap2.controller.excel.map.repo.DistrictParameterHistoryRepository;
import com.areap2.controller.excel.map.repo.DistrictParameterRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DistrictParameterServiceImpl {

	Logger log = LoggerFactory.getLogger(DistrictParameterServiceImpl.class);

	@Autowired
	private DistrictParameterRepository repository;

	@Autowired
	private DistrictParameterHistoryRepository historyRepository;

	public void save(DistrictParameterRequest request) {

		log.info("Saving district parameter. District={}, Parameter={}, Band={}", request.getDistrict(),
				request.getParameterName(), request.getBand());

		repository.findByDistrictAndParameterNameAndRuralUrbanAndBand(request.getDistrict(), request.getParameterName(),
				request.getRuralUrban(), request.getBand()).ifPresent(x -> {
					throw new RuntimeException("Configuration already exists.");
				});

		DistrictParameterMaster entity = new DistrictParameterMaster();

		entity.setDistrict(request.getDistrict());
		entity.setParameterName(request.getParameterName());
		entity.setRuralUrban(request.getRuralUrban());
		entity.setBand(request.getBand());
		entity.setDistanceFrom(request.getDistanceFrom());
		entity.setDistanceTo(request.getDistanceTo());
		entity.setWeightage(request.getWeightage());
		entity.setPerpetual(request.getPerpetual());
		entity.setActive(true);
		entity.setCreatedBy("SYSTEM");
		entity.setCreatedOn(LocalDateTime.now());
		repository.save(entity);

		log.info("District parameter saved successfully.");
	}

	public void saveAll(List<DistrictParameterRequest> requests) {

		List<DistrictParameterMaster> entities = new ArrayList<>();

		for (DistrictParameterRequest request : requests) {

			DistrictParameterMaster entity = new DistrictParameterMaster();

			entity.setDistrict(request.getDistrict());
			entity.setParameterName(request.getParameterName());
			entity.setRuralUrban(request.getRuralUrban());
			entity.setBand(request.getBand());
			entity.setDistanceFrom(request.getDistanceFrom());
			entity.setDistanceTo(request.getDistanceTo());
			entity.setWeightage(request.getWeightage());
			entity.setPerpetual(request.getPerpetual());
			entity.setActive(true);

			entities.add(entity);
		}

		repository.saveAll(entities);
	}

	@Transactional
	public void update(Long id, DistrictParameterRequest request) {

		log.info("Updating district parameter id={}", id);

		LocalDateTime now = LocalDateTime.now();

		// Fetch existing record
		DistrictParameterMaster oldEntity = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Record not found"));

		// Mark old record as inactive
		oldEntity.setPerpetual(false);
		oldEntity.setActive(false);
		oldEntity.setUpdatedBy("SYSTEM");
		oldEntity.setUpdatedOn(now);

		repository.save(oldEntity);

		// Create new record
		DistrictParameterMaster newEntity = new DistrictParameterMaster();

		// Mandatory Fields
		newEntity.setDistrict(request.getDistrict());
		newEntity.setParameterName(request.getParameterName());
		newEntity.setRuralUrban(request.getRuralUrban());
		newEntity.setBand(request.getBand());
		newEntity.setDistanceFrom(request.getDistanceFrom());
		newEntity.setDistanceTo(request.getDistanceTo());
		newEntity.setWeightage(request.getWeightage());

		// Status
		newEntity.setPerpetual(true);
		newEntity.setActive(true);

		// Audit
		newEntity.setCreatedBy("SYSTEM");
		newEntity.setCreatedOn(now);
		newEntity.setUpdatedBy("SYSTEM");
		newEntity.setUpdatedOn(now);

		repository.save(newEntity);

		log.info("District parameter updated successfully. Old record deactivated and new record created.");
	}

	public List<DistrictParameterMaster> getDistrict(String district) {

		log.info("Fetching configuration for district={}", district);

		return repository.findByDistrictAndActiveTrue(district);
	}

	////////////////////// new logic///////////////////////////////////
	private void saveHistory(DistrictParameterMaster entity, String action) {

		DistrictParameterMasterHistory history = new DistrictParameterMasterHistory();

		history.setMasterId(entity.getId());
		history.setDistrict(entity.getDistrict());
		history.setParameterName(entity.getParameterName());
		history.setRuralUrban(entity.getRuralUrban());
		history.setBand(entity.getBand());
		history.setDistanceFrom(entity.getDistanceFrom());
		history.setDistanceTo(entity.getDistanceTo());
		history.setWeightage(entity.getWeightage());
		history.setPerpetual(entity.getPerpetual());
		history.setActive(entity.getActive());

		history.setCreatedBy(entity.getCreatedBy());
		history.setCreatedOn(entity.getCreatedOn());
		history.setUpdatedBy(entity.getUpdatedBy());
		history.setUpdatedOn(entity.getUpdatedOn());

		history.setAction(action);
		history.setActionBy("SYSTEM");
		history.setActionOn(LocalDateTime.now());

		historyRepository.save(history);
	}

	public DistrictParameterMaster save(DistrictParameterMaster entity) {

		entity.setCreatedBy("SYSTEM");

		return repository.save(entity);
	}

	public List<DistrictParameterMaster> getAll() {
		return repository.findAll();
	}

	public DistrictParameterMaster getById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public DistrictParameterMaster update(Long id, DistrictParameterMaster request) {

		DistrictParameterMaster entity = repository.findById(id).orElse(null);

		if (entity == null) {
			return null;
		}

		// Save old data into history table
		saveHistory(entity, "UPDATE");

		entity.setDistrict(request.getDistrict());
		entity.setParameterName(request.getParameterName());
		entity.setRuralUrban(request.getRuralUrban());
		entity.setBand(request.getBand());
		entity.setDistanceFrom(request.getDistanceFrom());
		entity.setDistanceTo(request.getDistanceTo());
		entity.setWeightage(request.getWeightage());
		entity.setPerpetual(request.getPerpetual());
		entity.setActive(request.getActive());

		entity.setUpdatedBy("SYSTEM");
		entity.setUpdatedOn(LocalDateTime.now());

		return repository.save(entity);
	}

	public void delete(Long id) {

		DistrictParameterMaster entity = repository.findById(id).orElse(null);

		if (entity == null) {
			return;
		}

		// Save deleted record into history
		saveHistory(entity, "DELETE");

		repository.delete(entity);
	}
	
	
}
