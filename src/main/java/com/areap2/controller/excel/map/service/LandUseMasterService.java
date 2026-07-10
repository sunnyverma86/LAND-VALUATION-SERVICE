package com.areap2.controller.excel.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.areap2.controller.excel.map.enity.LandUseMaster;
import com.areap2.controller.excel.map.repo.LandUseMasterRepository;

@Service
public class LandUseMasterService {

	@Autowired
	private LandUseMasterRepository repository;

	public LandUseMaster save(LandUseMaster landUseMaster) {
		return repository.save(landUseMaster);
	}

	public LandUseMaster update(Long id, LandUseMaster landUseMaster) {

		LandUseMaster existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Land Use not found"));

		existing.setLandUseName(landUseMaster.getLandUseName());
		existing.setStatus(landUseMaster.getStatus());

		return repository.save(existing);
	}

	public List<LandUseMaster> getAll() {
		return repository.findAll();
	}

	public LandUseMaster getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Land Use not found"));
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

}
