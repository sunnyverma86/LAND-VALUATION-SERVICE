
package com.areap2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.entity.MarketValuationEntity;
import com.areap2.model.external.MarketValuationRequest;
import com.areap2.model.external.MarketValuationResponse;
import com.areap2.service.MarketValuationService;
import com.areap2.utils.MarketValuationException;

@RestController
@RequestMapping("/valuation")
public class MarketValuationController {

	private static final Logger log = LoggerFactory.getLogger(MarketValuationController.class);

	@Autowired
	private MarketValuationService valuationService;

	/**
	 * Save valuation request
	 */
	@PostMapping("/calculate")
	public ResponseEntity<?> calculateMarketValue(@RequestBody MarketValuationRequest request) {

		String methodName = "calculateMarketValue";
		log.info("START - [{}] in [{}]", methodName, this.getClass().getSimpleName());
		log.debug("Incoming request payload: {}", request);

		try {
			MarketValuationEntity savedEntity = valuationService.saveValuation(request);

			log.info("Valuation saved successfully with ID: {}", savedEntity.getId());

			Map<String, Object> response = new HashMap<>();
			response.put("status", "SUCCESS");
			response.put("message", "Valuation saved successfully");
			response.put("savedId", savedEntity.getId());

			log.info("END - [{}]", methodName);
			return ResponseEntity.ok(response);

		} catch (Exception e) {
			log.error("ERROR in [{}]: {}", methodName, e.getMessage(), e);

			Map<String, Object> error = new HashMap<>();
			error.put("status", "FAILED");
			error.put("message", "Error occurred while saving valuation");
			error.put("error", e.getMessage());

			return ResponseEntity.internalServerError().body(error);
		}
	}

	/**
	 * Fetch all valuations
	 */
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {

		String methodName = "getAll";
		log.info("START - [{}] in [{}]", methodName, this.getClass().getSimpleName());

		try {
			var list = valuationService.getAll();
			log.info("Fetched {} valuation records", list.size());

			log.info("END - [{}]", methodName);
			return ResponseEntity.ok(list);

		} catch (Exception e) {
			log.error("ERROR in [{}]: {}", methodName, e.getMessage(), e);

			Map<String, Object> error = new HashMap<>();
			error.put("status", "FAILED");
			error.put("message", "Error occurred while fetching all valuations");
			error.put("error", e.getMessage());

			return ResponseEntity.internalServerError().body(error);
		}
	}

	/**
	 * Fetch by plot number
	 */
	@GetMapping("/by-plot/{plotNo}")
	public ResponseEntity<?> getByPlotNo(@PathVariable String plotNo) {

		String methodName = "getByPlotNo";
		log.info("START - [{}] in [{}] with plotNo={}", methodName, this.getClass().getSimpleName(), plotNo);

		try {
			var entities = valuationService.getByPlotNo(plotNo);
			log.info("Records found for plotNo {}: {}", plotNo, entities.size());

			// Convert List<Entity> → List<Response>
			List<MarketValuationResponse> responseList = entities.stream()
					.map(e -> valuationService.convertToResponse(e)).toList();

			log.info("END - [{}]", methodName);
			return ResponseEntity.ok(responseList);

		} catch (Exception e) {
			log.error("ERROR in [{}] for plotNo={}: {}", methodName, plotNo, e.getMessage(), e);

			Map<String, Object> error = new HashMap<>();
			error.put("status", "FAILED");
			error.put("message", "Error occurred while fetching valuation by plot number");
			error.put("error", e.getMessage());

			return ResponseEntity.internalServerError().body(error);
		}
	}

	@GetMapping("/allPlotsByAttributes")
	public ResponseEntity<?> getAllPlotsByAttributes(@RequestParam String districtCode, @RequestParam String circleCode,
			@RequestParam String mouzaCode, @RequestParam String lotCode, @RequestParam String villageCode) {

		log.debug(
				"API Call: /allPlotsByAttributes | Params - districtCode={}, circleCode={}, mouzaCode={}, lotCode={}, villageCode={}",
				districtCode, circleCode, mouzaCode, lotCode, villageCode);

		try {
			List<String> plotNos = valuationService.getAllPlotNosByAttributes(districtCode, circleCode, mouzaCode,
					lotCode, villageCode);

			if (plotNos.isEmpty()) {
				log.warn("No plot numbers found for the provided parameters.");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No plot numbers found for the given filters.");
			}

			log.info("Returning {} plot numbers.", plotNos.size());
			return ResponseEntity.ok(plotNos);

		} catch (MarketValuationException ex) {
			log.error("Business error occurred: {}", ex.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());

		} catch (Exception ex) {
			log.error("Unexpected internal server error: {}", ex.getMessage(), ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error occurred.");
		}
	}

}
