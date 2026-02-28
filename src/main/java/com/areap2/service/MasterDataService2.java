package com.areap2.service;

import java.math.BigDecimal;

import com.areap2.model.AreaTypesModelRequest;
import com.areap2.model.BasePriceUpdateDetailsModelRequest;
import com.areap2.model.CircleDetailsModelRequest;
import com.areap2.model.CircleDetailsModelUpdateRequest;
import com.areap2.model.DistrictDetailsModelRequest;
import com.areap2.model.LandCategoriesModelRequest;
import com.areap2.model.LandSubClassDetailsModelRequest;
import com.areap2.model.LandSubClassDetailsModelUpdateRequest;
import com.areap2.model.LotDetailsModelRequest;
import com.areap2.model.LotDetailsModelUpdateRequest;
import com.areap2.model.MouzaDetailsModelRequest;
import com.areap2.model.MouzaDetailsModelUpdateRequest;
import com.areap2.model.ParameterDetailsModelRequest;
import com.areap2.model.ParameterDetailsModelUpdateRequest;
import com.areap2.model.ResponseModel;
import com.areap2.model.SroDetailsModelRequest;
import com.areap2.model.SroDetailsModelUpdateRequest;
import com.areap2.model.SubParameterDetailsModelRequest;
import com.areap2.model.SubParameterDetailsModelUpdateRequest;
import com.areap2.model.VillageDetailsModelRequest;
import com.areap2.model.VillageDetailsModelUpdateRequest;

public interface MasterDataService2 {

	ResponseModel getAllDistrictDetails();

	ResponseModel addDistrictDetails(DistrictDetailsModelRequest districtDetailsModel);

	ResponseModel updateDistrictDetails(DistrictDetailsModelRequest districtDetailsModel);

	ResponseModel deleteDistrictDetails(String districtCode);

	ResponseModel getCircleByDistrict(String districtCode);

	ResponseModel addCircleDetails(CircleDetailsModelRequest circleDetailsModel);

	ResponseModel updateCircleDetails(CircleDetailsModelUpdateRequest circleDetailsModel);

	ResponseModel deleteCircleDetails(String circleCode);

	ResponseModel getVillageByDistrictAndCircle(String districtCode, String circleCode);

	ResponseModel addVillageDetails(VillageDetailsModelRequest villageDetailsModel);

	ResponseModel updateVillageDetails(VillageDetailsModelUpdateRequest villageDetailsModel);

	ResponseModel deleteVillageDetails(String villageCode);

	ResponseModel getMouzaDetails(String districtCode, String circleCode);

	ResponseModel addMouzaDetails(MouzaDetailsModelRequest mouzaDetailsModel);

	ResponseModel updateMouzaDetails(MouzaDetailsModelUpdateRequest mouzaDetailsModel);

	ResponseModel deleteMouzaDetails(String mouzaCode);

	ResponseModel getAllLandCategories();

	ResponseModel addLandCategory(LandCategoriesModelRequest landCategoriesModel);

//	ResponseModel updateLandCategory(LandCategoriesModel landCategoriesModel);
	ResponseModel deleteLandsCategory(String landCategoryCode);

	ResponseModel getAreaType();

	ResponseModel addAreaType(AreaTypesModelRequest areaTypesModel);

	ResponseModel deleteAreaType(Long areaTypesGenId);

//	ResponseModel getZonalValues(String districtCode,String circleCode,String villageCode);
	ResponseModel getZonalValues(String districtCode, String circleCode, String mouzaCode);

	ResponseModel getParameterDetails(BigDecimal minRange, BigDecimal maxRange);

	ResponseModel getLotDetails(String districtCode, String circleCode);

	ResponseModel addLotDetails(LotDetailsModelRequest lotDetailsModel);

	ResponseModel updateLotDetails(LotDetailsModelUpdateRequest lotDetailsModel);

	ResponseModel deleteLotDetails(String lotCode);

	ResponseModel addSroDetails(SroDetailsModelRequest sroDetailsModel);

	ResponseModel updateSroDetails(SroDetailsModelUpdateRequest sroDetailsModel);

	ResponseModel deleteSroDetails(String sroCode);

	ResponseModel getLotByDistrictAndCircle(String districtCode, String circleCode);

	ResponseModel getLandSubClassByLandClassName(String landClassName);

	ResponseModel deleteLandSubClassDetails(String landSubClass);

	ResponseModel updateLandSubClassDetails(LandSubClassDetailsModelUpdateRequest landSubClassDetailsModel);

	ResponseModel addLandSubClassDetails(LandSubClassDetailsModelRequest landSubClassDetailsModel);

	ResponseModel updateBasePriceDetails(BasePriceUpdateDetailsModelRequest bPRequest);

	ResponseModel getParameterDetailsDynamic();

	ResponseModel getAllLandCategoriesByMouza(String mouzaCode);

	ResponseModel getAreaTypeByMouza(String mouzaCode);

	ResponseModel getParameterDetailsDynamicByMasterCode(String masterCode);

	ResponseModel getParameterDetailsDynamicByMasterSubCode(String masterSubCode);

	ResponseModel getVillageByDistrictAndCircleAndMauzaAndLot(String districtCode, String circleCode, String mauza,
			String lot);

	ResponseModel getLotByDistrictAndCircleAndMouza(String districtCode, String circleCode, String mouzaCode);

	ResponseModel addParameterDetailsOld(ParameterDetailsModelRequest parameterDetailsModel);
	
	ResponseModel addParameterDetails(ParameterDetailsModelRequest parameterDetailsModel);

	ResponseModel updateParameterDetails(ParameterDetailsModelUpdateRequest parameterDetailsModel);

	ResponseModel deleteParameterDetails(String parameterCode);

	ResponseModel addSubParameterDetails(SubParameterDetailsModelRequest subParameterDetailsModel);

	ResponseModel updateSubParameterDetails(SubParameterDetailsModelUpdateRequest subParameterDetailsModel);

	ResponseModel deleteSubParameterDetails(String subParameterCode);

	ResponseModel getParameterDetailsAll();

	ResponseModel getSubParameterDetailsAllByParameterCode(String parameterCode);
	
	ResponseModel getSubParameterDetailsAllByParameterCodeAndDistrictCode(String parameterCode,String districtCode);

	ResponseModel addLandsCategory(String landCategoryName);

	void autoCreateLotsForAllMouzas();
	
	void autoCreateVillageForAllLots();

	ResponseModel getAllLandsCategoryDetails();

}
