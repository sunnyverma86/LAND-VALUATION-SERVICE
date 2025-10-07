package com.areap2.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.areap2.repository.AreaTypesRepo;
import com.areap2.repository.AuditLogRepo;
import com.areap2.repository.CircleDetailsRepo;
import com.areap2.repository.ClusterDetailsRepo;
import com.areap2.repository.DistrictDetailsRepo;
import com.areap2.repository.LandCategoriesRepo;
import com.areap2.repository.LandSubClassDetailsRepo;
import com.areap2.repository.LotDetailsRepo;
import com.areap2.repository.MouzaDetailsRepo;
import com.areap2.repository.ParameterDetailsRepo;
import com.areap2.repository.ProcedureRepo;
import com.areap2.repository.VillageDetailsRepo;
import com.areap2.repository.ZonalValuesRepo;
import com.areap2.repository.duty.StampDutyCalculationRepo;

public abstract class AbstractMasterRepository {

	@Autowired
	DistrictDetailsRepo districtDetailsRepo;

	@Autowired
	CircleDetailsRepo circleDetailsRepo;

	@Autowired
	VillageDetailsRepo villageDetailsRepo;

	@Autowired
	MouzaDetailsRepo mouzaDetailsRepo;

	@Autowired
	LandCategoriesRepo landCategoriesRepo;

	@Autowired
	AreaTypesRepo areaTypesRepo;

	@Autowired
	ZonalValuesRepo zonalValuesRepo;

	@Autowired
	ParameterDetailsRepo parameterDetailsRepo;

	@Autowired
	ClusterDetailsRepo clusterDetailsRepo;

	@Autowired
	ProcedureRepo procedureRepo;

	@Autowired
	LotDetailsRepo lotDetailsRepo;

	@Autowired
	LandSubClassDetailsRepo landSubClassDetailsRepo;

	@Autowired
	AuditLogRepo auditLogRepo;

	@Autowired
	StampDutyCalculationRepo stampDutyCalculationRepo;

}
