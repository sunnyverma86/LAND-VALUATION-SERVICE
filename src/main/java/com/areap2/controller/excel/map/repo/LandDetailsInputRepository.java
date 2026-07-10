package com.areap2.controller.excel.map.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.LandDetailsInputEntity;

@Repository
public interface LandDetailsInputRepository extends JpaRepository<LandDetailsInputEntity, Long> {


	List<LandDetailsInputEntity> findByDistAndCircleAndMouzaAndLotAndVillageAndTextparcel(String district,
			String circle, String mouza, String lot, String village, String plot);

}
