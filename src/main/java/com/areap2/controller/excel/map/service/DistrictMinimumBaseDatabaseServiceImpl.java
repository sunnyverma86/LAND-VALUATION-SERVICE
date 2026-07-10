package com.areap2.controller.excel.map.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.areap2.controller.excel.map.enity.DistrictMinimumBaseDatabase;
import com.areap2.controller.excel.map.repo.DistrictMinimumBaseDatabaseRepository;
import com.areap2.model.ResponseModel;

@Service
public class DistrictMinimumBaseDatabaseServiceImpl {

	@Autowired
	private DistrictMinimumBaseDatabaseRepository repository;

	public ResponseModel getAll() {

		ResponseModel response = new ResponseModel();

		List<DistrictMinimumBaseDatabase> list = repository.findByStatus("ACTIVE");

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Records fetched successfully.");
		response.setData(list);

		return response;
	}

	public ResponseModel save(DistrictMinimumBaseDatabase request) {

//		String user = SecurityContextHolder.getContext()
//                .getAuthentication()
//                .getName();
//
//request.setCreatedBy(user);
//request.setUpdatedBy(user);

		ResponseModel response = new ResponseModel();

		request.setStatus("ACTIVE");
		request.setCreatedBy("SYSTEM"); // Logged-in user
		request.setCreatedDtm(LocalDateTime.now());

		request.setUpdatedBy("SYSTEM");
		request.setUpdatedDtm(LocalDateTime.now());

		repository.save(request);

		response.setHttpStatus(HttpStatus.OK);
		response.setMessage("Record saved successfully.");
		response.setData(request);

		return response;
	}

	public ResponseModel getById(Long id) {

		ResponseModel response = new ResponseModel();

		Optional<DistrictMinimumBaseDatabase> optional = repository.findByIdAndStatus(id, "ACTIVE");

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

	public ResponseModel update(Long id, DistrictMinimumBaseDatabase request) {

		ResponseModel response = new ResponseModel();

		Optional<DistrictMinimumBaseDatabase> optional = repository.findById(id);

		if (optional.isPresent()) {

			// Logged in user
			String user = "SYSTEM";

			// Old Record
			DistrictMinimumBaseDatabase oldRecord = optional.get();

			oldRecord.setStatus("INACTIVE");
			oldRecord.setUpdatedBy(user);
			oldRecord.setUpdatedDtm(LocalDateTime.now());

			repository.save(oldRecord);

			// New Record
			DistrictMinimumBaseDatabase newRecord = new DistrictMinimumBaseDatabase();

			newRecord.setDistrict(request.getDistrict());
			newRecord.setRuralUrban(request.getRuralUrban());
			newRecord.setLandUse(request.getLandUse());
			newRecord.setDistrictMinimumValue(request.getDistrictMinimumValue());

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

		Optional<DistrictMinimumBaseDatabase> optional = repository.findByIdAndStatus(id, "ACTIVE");

		if (optional.isPresent()) {

			DistrictMinimumBaseDatabase entity = optional.get();

			entity.setStatus("INACTIVE");
			entity.setUpdatedBy("SYSTEM"); // Logged-in user
			entity.setUpdatedDtm(LocalDateTime.now());

			repository.save(entity);

			response.setHttpStatus(HttpStatus.OK);
			response.setMessage("Record deleted successfully.");
			response.setData(entity);

		} else {

			response.setHttpStatus(HttpStatus.NOT_FOUND);
			response.setMessage("Record not found.");
		}

		return response;
	}
}
