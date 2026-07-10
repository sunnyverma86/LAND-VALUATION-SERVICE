package com.areap2.controller.excel.map.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.areap2.controller.excel.map.enity.VillageLandClassEntity;
import com.areap2.controller.excel.map.repo.VillageLandClassRepository;
import com.areap2.model.ResponseModel;

@Service
public class VillageLandClassServiceImpl {

	@Autowired
	private VillageLandClassRepository repository;

	public ResponseModel save(VillageLandClassEntity request) {

		ResponseModel response = new ResponseModel();

		String user = "SYSTEM";
		
		request.setStatus("ACTIVE");
		request.setCreatedBy(user);
		request.setCreatedDtm(LocalDateTime.now());
		request.setUpdatedBy(user);
		request.setUpdatedDtm(LocalDateTime.now());

		repository.save(request);

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Record saved successfully.");
		response.setData(request);

		return response;
	}

	public ResponseModel getAll() {

		ResponseModel response = new ResponseModel();

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Records fetched successfully.");
		response.setData(repository.findByStatus("ACTIVE"));

		return response;
	}

	public ResponseModel getAllWithInactive() {

		ResponseModel response = new ResponseModel();

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Records fetched successfully.");
		response.setData(repository.findAll());

		return response;
	}

	public ResponseModel getById(Long id) {

		ResponseModel response = new ResponseModel();

		Optional<VillageLandClassEntity> optional = repository.findByIdAndStatus(id, "ACTIVE");

		if (optional.isPresent()) {

			response.setHttpStatus(HttpStatus.OK);
			response.setData(optional.get());

		} else {

			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Active record not found.");
		}

		return response;
	}

	public ResponseModel update(Long id, VillageLandClassEntity request) {

		ResponseModel response = new ResponseModel();

		Optional<VillageLandClassEntity> optional = repository.findByIdAndStatus(id, "ACTIVE");

		if (optional.isPresent()) {

			String user = "SYSTEM";

			VillageLandClassEntity oldRecord = optional.get();

			oldRecord.setStatus("INACTIVE");
			oldRecord.setUpdatedBy(user);
			oldRecord.setUpdatedDtm(LocalDateTime.now());

			repository.save(oldRecord);

			VillageLandClassEntity newRecord = new VillageLandClassEntity();

			newRecord.setExcelId(request.getExcelId());
			newRecord.setVillage(request.getVillage());
			newRecord.setRuralUrban(request.getRuralUrban());
			newRecord.setLandClass(request.getLandClass());
			newRecord.setMinWithoutOutliers(request.getMinWithoutOutliers());
			newRecord.setEquivalentMinimum(request.getEquivalentMinimum());
			newRecord.setNameOfEquivalent(request.getNameOfEquivalent());
			newRecord.setLuf(request.getLuf());
			newRecord.setMinEquivalentValue(request.getMinEquivalentValue());
			newRecord.setFinalMinEq(request.getFinalMinEq());
			newRecord.setMouzaCode(request.getMouzaCode());
			newRecord.setUniqueId(request.getUniqueId());
			newRecord.setMouzaName(request.getMouzaName());
			newRecord.setMouzaMin(request.getMouzaMin());
			newRecord.setBandRatio(request.getBandRatio());

			newRecord.setStatus("ACTIVE");
			newRecord.setCreatedBy(user);
			newRecord.setCreatedDtm(LocalDateTime.now());
			newRecord.setUpdatedBy(user);
			newRecord.setUpdatedDtm(LocalDateTime.now());

			repository.save(newRecord);

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record updated successfully.");
			response.setData(newRecord);

		} else {

			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Active record not found.");
		}

		return response;
	}

	public ResponseModel delete(Long id) {

		ResponseModel response = new ResponseModel();

		Optional<VillageLandClassEntity> optional = repository.findByIdAndStatus(id, "ACTIVE");

		if (optional.isPresent()) {

			String user = "SYSTEM";

			VillageLandClassEntity record = optional.get();

			record.setStatus("INACTIVE");
			record.setUpdatedBy(user);
			record.setUpdatedDtm(LocalDateTime.now());

			repository.save(record);

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record deleted successfully.");

		} else {

			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Active record not found.");
		}

		return response;
	}
}
