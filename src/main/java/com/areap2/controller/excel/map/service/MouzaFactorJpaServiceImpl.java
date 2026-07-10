package com.areap2.controller.excel.map.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.areap2.controller.excel.map.enity.MouzaFactorBaseDatabase;
import com.areap2.controller.excel.map.repo.MouzaFactorJpaRepository;
import com.areap2.model.ResponseModel;

@Service
public class MouzaFactorJpaServiceImpl {

	@Autowired
	private MouzaFactorJpaRepository repository;

	public ResponseModel save(MouzaFactorBaseDatabase request) {

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

	public ResponseModel getAllWithInactive() {

		ResponseModel response = new ResponseModel();

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Records fetched successfully.");
		response.setData(repository.findAll());

		return response;
	}

	public ResponseModel getAll() {

		ResponseModel response = new ResponseModel();

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Records fetched successfully.");
		response.setData(repository.findByStatus("ACTIVE"));

		return response;
	}

	public ResponseModel getById(Long id) {

		ResponseModel response = new ResponseModel();

		Optional<MouzaFactorBaseDatabase> optional = repository.findByIdAndStatus(id, "ACTIVE");

		if (optional.isPresent()) {

			response.setHttpStatus(HttpStatus.OK);
			response.setData(optional.get());

		} else {

			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Active record not found.");
		}

		return response;
	}

	public ResponseModel update(Long id, MouzaFactorBaseDatabase request) {

		ResponseModel response = new ResponseModel();

		Optional<MouzaFactorBaseDatabase> optional = repository.findByIdAndStatus(id, "ACTIVE");

		if (optional.isPresent()) {

			String user = "SYSTEM";

			// Old Record
			MouzaFactorBaseDatabase oldRecord = optional.get();

			oldRecord.setStatus("INACTIVE");
			oldRecord.setUpdatedBy(user);
			oldRecord.setUpdatedDtm(LocalDateTime.now());

			repository.save(oldRecord);

			// New Version
			MouzaFactorBaseDatabase newRecord = new MouzaFactorBaseDatabase();

			newRecord.setDistrict(request.getDistrict());
			newRecord.setMouza(request.getMouza());
			newRecord.setRuralUrban(request.getRuralUrban());
			newRecord.setLandUse(request.getLandUse());
			newRecord.setMinExcl(request.getMinExcl());
			newRecord.setHigherLandClassMin(request.getHigherLandClassMin());
			newRecord.setLc(request.getLc());
			newRecord.setLuf(request.getLuf());
			newRecord.setDistrictMinimum(request.getDistrictMinimum());
			newRecord.setCurrent(request.getCurrent());
			newRecord.setFinalMfZonalValue(request.getFinalMfZonalValue());

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

		Optional<MouzaFactorBaseDatabase> optional = repository.findByIdAndStatus(id, "ACTIVE");

		if (optional.isPresent()) {

			String user = "SYSTEM";

			MouzaFactorBaseDatabase record = optional.get();

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
