package com.areap2.controller.excel.map.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.areap2.controller.excel.map.enity.DistrictMinimumBaseDatabase;
import com.areap2.controller.excel.map.enity.LandUseFactorExcelEntity;
import com.areap2.controller.excel.map.repo.LandUseFactorExcelEntityRepository;
import com.areap2.model.ResponseModel;

@Service
public class LandUseFactorExcelServiceImpl {

	@Autowired
	private LandUseFactorExcelEntityRepository repository;

	public ResponseModel save(LandUseFactorExcelEntity request) {

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

		List<LandUseFactorExcelEntity> list = repository.findByStatus("ACTIVE");

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Records fetched successfully.");
		response.setData(list);

		return response;
	}

	public ResponseModel getById(Long id) {

		ResponseModel response = new ResponseModel();

		Optional<LandUseFactorExcelEntity> optional = repository.findByIdAndStatus(id, "ACTIVE");

		if (optional.isPresent()) {

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record found.");
			response.setData(optional.get());

		} else {

			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Record not found.");
		}

		return response;
	}

	
	
	
	
	
	

	public ResponseModel update(Long id, LandUseFactorExcelEntity request) {

		ResponseModel response = new ResponseModel();

		Optional<LandUseFactorExcelEntity> optional = repository.findById(id);

		if (optional.isPresent()) {

			String user = "SYSTEM";

			// Existing Record
			LandUseFactorExcelEntity oldRecord = optional.get();

			oldRecord.setStatus("INACTIVE");
			oldRecord.setUpdatedBy(user);
			oldRecord.setUpdatedDtm(LocalDateTime.now());

			repository.save(oldRecord);

			// New Record
			LandUseFactorExcelEntity newRecord = new LandUseFactorExcelEntity();

			newRecord.setDistrict(request.getDistrict());
			newRecord.setLandUse(request.getLandUse());
			newRecord.setRuralUrban(request.getRuralUrban());
			newRecord.setLuf(request.getLuf());

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
			response.setMessage("Record not found.");
		}

		return response;
	}

	public ResponseModel delete(Long id) {

		ResponseModel response = new ResponseModel();

		Optional<LandUseFactorExcelEntity> optional = repository.findByIdAndStatus(id, "ACTIVE");

		if (optional.isPresent()) {

			String user = "SYSTEM";

			LandUseFactorExcelEntity record = optional.get();

			record.setStatus("INACTIVE");
			record.setUpdatedBy(user);
			record.setUpdatedDtm(LocalDateTime.now());

			repository.save(record);

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record deleted successfully.");

		} else {

			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Record not found.");
		}

		return response;
	}

}
