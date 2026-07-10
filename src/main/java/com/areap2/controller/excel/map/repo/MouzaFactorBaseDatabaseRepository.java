package com.areap2.controller.excel.map.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.MouzaFactorBaseDatabase;

@Repository
public interface MouzaFactorBaseDatabaseRepository  {
	
	void saveBatch(List<MouzaFactorBaseDatabase> records);

}
