package com.areap2.controller.excel.map.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.areap2.controller.excel.map.enity.BaseParameterDetails;
import com.areap2.controller.excel.map.repo.BaseParameterDetailsRepository;

@Service
public class BaseParameterDetailsService {

	@Autowired
	private BaseParameterDetailsRepository repository;

	public BaseParameterDetails save(BaseParameterDetails entity) {

		entity.setCreatedBy("SYSTEM");
		entity.setCreatedDtm(LocalDateTime.now());

		if (entity.getStatus() == null) {
			entity.setStatus("ACTIVE");
		}

		return repository.save(entity);
	}

	public List<BaseParameterDetails> getAll() {
	    return repository.findByStatus("ACTIVE");
	}

	public BaseParameterDetails getById(Long id) {
	    return repository.findByIdAndStatus(id, "ACTIVE").orElse(null);
	}

	public void delete(Long id) {

	    BaseParameterDetails entity = repository.findByIdAndStatus(id, "ACTIVE").orElse(null);

	    if (entity != null) {
	        entity.setStatus("INACTIVE");
	        entity.setUpdatedBy("SYSTEM");
	        entity.setUpdatedDtm(LocalDateTime.now());

	        repository.save(entity);
	    }
	}

	public BaseParameterDetails update(Long id, BaseParameterDetails request) {

	    BaseParameterDetails existing = repository.findById(id).orElse(null);

	    if (existing == null) {
	        return null;
	    }

	    // Soft delete the existing record
	    existing.setStatus("INACTIVE");
	    existing.setUpdatedBy("SYSTEM");
	    existing.setUpdatedDtm(LocalDateTime.now());

	    repository.save(existing);

	    // Create a new record
	    BaseParameterDetails newEntity = new BaseParameterDetails();

	    newEntity.setParameterName(request.getParameterName());
	    newEntity.setAppreciationType(request.getAppreciationType());
	    newEntity.setDiscription(request.getDiscription());
	    newEntity.setVisibleToCitizen(request.isVisibleToCitizen());
	    newEntity.setTypeOfParameter(request.getTypeOfParameter());
	    newEntity.setDistrict(request.getDistrict());

	    newEntity.setStatus("ACTIVE");
	    newEntity.setCreatedBy("SYSTEM");
	    newEntity.setCreatedDtm(LocalDateTime.now());

	  
	    return repository.save(newEntity);
	}

	

}
