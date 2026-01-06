package com.areap2.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.areap2.entity.MarketValuationEntity;
import com.areap2.model.PlotNumberModelRequest;
import com.areap2.model.external.AreaDetailsExternal;
import com.areap2.model.external.JurisdictionInformationExternal;
import com.areap2.model.external.LandTypeDetailsExternal;
import com.areap2.model.external.MarketValuationRequest;
import com.areap2.model.external.MarketValuationResponse;
import com.areap2.model.external.ParameterDetailExternal;
import com.areap2.model.external.PayloadExternal;
import com.areap2.model.external.PlotLandDetailsExternal;
import com.areap2.repository.MarketValuationRepository;
import com.areap2.service.MarketValuationService;
import com.areap2.utils.MarketValuationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MarketValuationServiceImpl implements MarketValuationService {

	private static final Logger log = LoggerFactory.getLogger(MarketValuationServiceImpl.class);

	@Autowired
	private MarketValuationRepository repository;

	@Autowired
	private ObjectMapper objectMapper;

	// -------------------------------------------------
	// SAVE VALUATION
	// -------------------------------------------------
	@Override
	public MarketValuationEntity saveValuation(MarketValuationRequest request) {

		log.info("START - Saving Market Valuation | Mode: {}", request.getMode());

		MarketValuationEntity entity = new MarketValuationEntity();

		try {
			PayloadExternal payload = request.getPayloadExternal();
			if (payload == null) {
				log.error("Payload is missing in request.");
				throw new RuntimeException("Payload cannot be null.");
			}

			// Basic
			entity.setMode(request.getMode());
			entity.setTotalMarketValuation(payload.getTotalMarketValuation());
			log.debug("Mapped basic details.");

			// Jurisdiction
			JurisdictionInformationExternal j = payload.getJurisdictionInformationExternal();
			if (j != null) {
				entity.setDistrictCode(j.getDistrictCode());
				entity.setCircleCode(j.getCircleCode());
				entity.setMouzaCode(j.getMouzaCode());
				entity.setVillageCode(j.getVillageCode());
				entity.setLotCode(j.getLotCode());
				entity.setPlotNo(j.getPlotNo());
				entity.setCurrentLandUse(j.getCurrentLandUse());

				log.debug("Mapped jurisdiction details for Plot: {}", j.getPlotNo());
			}

			// Land Type
			LandTypeDetailsExternal lt = payload.getLandTypeDetailsExternal();
			if (lt != null) {
				entity.setCurrentLandType(lt.getCurrentLandType());
				entity.setLandUseChange(lt.isLandUseChange());
				entity.setAreaType(lt.getAreaType());

				if (lt.getAreaDetailsExternal() != null) {
					entity.setTotalLessa(lt.getAreaDetailsExternal().getTotalLessa());
				}

				log.debug("Mapped land type details.");
			}

			// Parameter JSON
			try {
				String json = objectMapper.writeValueAsString(payload.getPlotLandDetailsExternal().getParameters());
				entity.setParametersJson(json);

				log.debug("Serialized parameters JSON successfully.");
			} catch (Exception jsonEx) {
				log.error("Failed to serialize parameters JSON.", jsonEx);
			}

			// Save
			MarketValuationEntity saved = repository.save(entity);
			log.info("SUCCESS - Saved Market Valuation | ID: {}", saved.getId());

			return saved;

		} catch (Exception e) {
			log.error("ERROR while saving valuation.", e);
			throw new RuntimeException("Failed to save valuation.", e);
		}
	}

	// -------------------------------------------------
	// GET ALL
	// -------------------------------------------------
	@Override
	public List<MarketValuationEntity> getAll() {
		log.info("Fetching all valuation records.");

		List<MarketValuationEntity> list = repository.findAll();

		log.info("Fetched {} records.", list.size());
		return list;
	}

	// -------------------------------------------------
	// GET BY PLOT NO
	// -------------------------------------------------
	@Override
	public List<MarketValuationEntity> getByPlotNo(String plotNo) {

		log.info("Fetching records for plotNo: {}", plotNo);
		List<MarketValuationEntity> list = repository.findByPlotNo(plotNo);

		if (list.isEmpty()) {
			log.warn("No records found for plotNo: {}", plotNo);
		} else {
			log.info("Found {} records.", list.size());
		}

		return list;
	}

	// -------------------------------------------------
	// CONVERT DB ENTITY → API RESPONSE
	// -------------------------------------------------
	@Override
	public MarketValuationResponse convertToResponse(MarketValuationEntity entity) {

		MarketValuationResponse response = new MarketValuationResponse();
		response.setId(entity.getId());
		response.setMode(entity.getMode());

		PayloadExternal payload = new PayloadExternal();

		// Jurisdiction
		JurisdictionInformationExternal j = new JurisdictionInformationExternal();
		j.setDistrictCode(entity.getDistrictCode());
		j.setCircleCode(entity.getCircleCode());
		j.setMouzaCode(entity.getMouzaCode());
		j.setVillageCode(entity.getVillageCode());
		j.setLotCode(entity.getLotCode());
		j.setCurrentLandUse(entity.getCurrentLandUse());
		j.setPlotNo(entity.getPlotNo());
		payload.setJurisdictionInformationExternal(j);

		// Land Type
		LandTypeDetailsExternal lt = new LandTypeDetailsExternal();
		lt.setCurrentLandType(entity.getCurrentLandType());
		lt.setLandUseChange(entity.getLandUseChange());
		lt.setAreaType(entity.getAreaType());

		AreaDetailsExternal area = new AreaDetailsExternal();
		area.setTotalLessa(entity.getTotalLessa());
		lt.setAreaDetailsExternal(area);
		payload.setLandTypeDetailsExternal(lt);

		// Deserialize JSON → List<ParameterDetailExternal>
		try {
			List<ParameterDetailExternal> params = objectMapper.readValue(entity.getParametersJson(),
					new TypeReference<List<ParameterDetailExternal>>() {
					});

			PlotLandDetailsExternal plot = new PlotLandDetailsExternal();
			plot.setLocationMethod("manual");
			plot.setParameters(params);

			payload.setPlotLandDetailsExternal(plot);

		} catch (Exception ex) {
			log.error("Error while converting parameters JSON.", ex);
		}

		// Total Valuation
		payload.setTotalMarketValuation(entity.getTotalMarketValuation());

		response.setPayloadExternal(payload);
		return response;
	}

	@Override
	public List<String> getAllPlotNosByAttributes(String districtCode, String circleCode, String mouzaCode,
			String lotCode, String villageCode) {

		log.debug(
				"Request received to fetch plot numbers with filters: "
						+ "districtCode={}, circleCode={}, mouzaCode={}, lotCode={}, villageCode={}",
				districtCode, circleCode, mouzaCode, lotCode, villageCode);

		try {

			// Validate Inputs
			if (districtCode == null || circleCode == null || mouzaCode == null || lotCode == null
					|| villageCode == null) {

				log.error("Invalid input: One or more required parameters are null.");
				throw new MarketValuationException("All parameters must be provided.");
			}

			// Fetch Data
			List<MarketValuationEntity> entityList = repository
					.findByDistrictCodeAndCircleCodeAndMouzaCodeAndVillageCodeAndLotCode(districtCode, circleCode,
							mouzaCode, villageCode, lotCode);

			log.info("Query executed successfully. Total records found: {}", entityList.size());

			if (entityList.isEmpty()) {
				log.warn("No records found for the provided filters.");
				return Collections.emptyList();
			}

			// Extract ONLY plotNo values
			List<String> plotNumbers = entityList.stream().map(MarketValuationEntity::getPlotNo)
					.filter(Objects::nonNull).distinct().collect(Collectors.toList());

			log.debug("Plot numbers extracted: {}", plotNumbers);

			log.info("Returning {} unique plot numbers.", plotNumbers.size());
			return plotNumbers;

		} catch (MarketValuationException ex) {
			log.error("Business validation failed: {}", ex.getMessage());
			throw ex;

		} catch (Exception ex) {
			log.error("Unexpected error while fetching plot numbers: {}", ex.getMessage(), ex);
			throw new MarketValuationException("Failed to fetch plot numbers.", ex);
		}
	}

}
