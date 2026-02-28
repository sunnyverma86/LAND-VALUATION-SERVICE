package com.areap2.utils;

import org.springframework.stereotype.Component;

import com.areap2.entity.LandAreaEntity;
import com.areap2.model.LandAreaRequest;

@Component
public class LandAreaMapper {

	public LandAreaEntity toEntity(LandAreaRequest request) {

		LandAreaEntity entity = new LandAreaEntity();

		entity.setArea(request.getArea());
		entity.setDistName(request.getDistName());
		entity.setRevenueCircle(request.getRevenueCircle());
		entity.setVillageName(request.getVillageName());
		entity.setMouzaName(request.getMouzaName());
		entity.setAreaType(request.getAreaType());
		entity.setLotNumber(request.getLotNumber());
		entity.setDagNInt(request.getDagNInt());
		entity.setDistFromCBD(request.getDistFromCBD());
		entity.setTypeOfCBD(request.getTypeOfCBD());
		entity.setRoadFid(request.getRoadFid());
		entity.setDistFromRoad(request.getDistFromRoad());
		entity.setTypeOfRoad(request.getTypeOfRoad());
		entity.setDistFromTransport(request.getDistFromTransport());
		entity.setDistFromEducation(request.getDistFromEducation());
		entity.setDistFromRestrictedArea(request.getDistFromRestrictedArea());
		entity.setDistFromOilPipeline(request.getDistFromOilPipeline());
		entity.setDistFromHeritage(request.getDistFromHeritage());
		entity.setDistFromFloodProne(request.getDistFromFloodProne());
		entity.setElevation(request.getElevation());

		return entity;
	}
}
