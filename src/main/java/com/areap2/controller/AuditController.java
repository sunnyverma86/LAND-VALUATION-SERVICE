package com.areap2.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.service.WorkFlowService;

@RestController
@RequestMapping("/audit")
@CrossOrigin
public class AuditController {

	@Autowired
	private WorkFlowService workFlowService;

	Logger log = LoggerFactory.getLogger(AuditController.class);

	@GetMapping("/get/pending/management")
	public List<?> getAllPendingForJuniorManager(@RequestParam String masterType, @RequestParam String statusCode) {
		final String methodName = "getAllPendingForJuniorManager";
		final String className = this.getClass().getSimpleName();

		long startTime = System.currentTimeMillis();
		log.info("[START] {} | class={} | masterType={} | statusCode={}", methodName, className, masterType,
				statusCode);

		List<?> result = Collections.emptyList();

		try {
			// Validate input
			if (masterType == null || masterType.isBlank() || statusCode == null || statusCode.isBlank()) {
				log.warn("[INVALID INPUT] {} | masterType={} | statusCode={} | class={}", methodName, masterType,
						statusCode, className);
				return result;
			}

			// Business logic call
			result = workFlowService.getRequestsByStatusCodeAndMaster(statusCode, masterType);

			// Log success
			log.info("[SUCCESS] {} | Retrieved {} records | masterType={} | statusCode={} | class={}", methodName,
					(result != null ? result.size() : 0), masterType, statusCode, className);

		} catch (Exception ex) {
			// Log error details with stack trace
			log.error("[ERROR] {} | masterType={} | statusCode={} | class={} | message={}", methodName, masterType,
					statusCode, className, ex.getMessage(), ex);
			throw ex; // rethrow or handle based on your global exception strategy
		} finally {
			long duration = System.currentTimeMillis() - startTime;
			log.info("[END] {} | ExecutionTime={}ms | masterType={} | class={}", methodName, duration, masterType,
					className);
		}

		return result;
	}

	@GetMapping("/update/action/jm")
	public ResponseEntity<?> updateRequestAction(@RequestParam Long id, @RequestParam String masterType,@RequestParam String masterCode,
			@RequestParam String action, @RequestParam String currentStatusCode) {

		final String methodName = "updateRequestActionjm";
		log.info("[START] {} | id={} | masterType={} | action={} | statusCode={} | class={}", methodName, id,
				masterType, action, currentStatusCode, this.getClass().getSimpleName());

		try {
			// Input validation
			if (id == null || masterType == null || masterType.isBlank() || action == null || action.isBlank()
					|| currentStatusCode == null || currentStatusCode.isBlank()) {

				log.warn("Invalid request parameters | id={} | masterType={} | action={} | statusCode={} | method={}",
						id, masterType, action, currentStatusCode, methodName);

				return ResponseEntity.badRequest().body(Map.of("message", "Invalid input parameters"));
			}

			// Service call
			List<?> result = workFlowService.getRequestsByIdAndMasterAndAction(id, masterType,masterCode, action,
					currentStatusCode);

			int count = (result != null ? result.size() : 0);
			log.info("[SUCCESS] {} executed | totalRecords={} | masterType={} | action={} | statusCode={}", methodName,
					count, masterType, action, currentStatusCode);

			// Return successful response
			return ResponseEntity
					.ok(Map.of("message", "Action processed successfully", "recordsUpdated", count, "data", result));

		} catch (Exception ex) {
			log.error("[ERROR] Exception occurred in {} | id={} | masterType={} | action={} | error={}", methodName, id,
					masterType, action, ex.getMessage(), ex);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("message", "An unexpected error occurred", "error", ex.getMessage()));
		}
	}

	@GetMapping("/update/action/man")
	public ResponseEntity<?> updateRequestActionMan(@RequestParam Long id, @RequestParam String masterType,@RequestParam String masterCode,
			@RequestParam String action, @RequestParam String currentStatusCode) {

		final String methodName = "updateRequestActionMan";
		log.info("[START] {} | id={} | masterType={} | masterCode={} | action={} | currentStatusCode={} | class={}", methodName, id,
				masterType, action, currentStatusCode, this.getClass().getSimpleName());

		try {
			// Input validation
			if (id == null || masterType == null || masterType.isBlank() || masterCode.isBlank() || action == null || action.isBlank()
					|| currentStatusCode == null || currentStatusCode.isBlank()) {

				log.warn("Invalid request parameters | id={} | masterType={} | masterCode={} | action={} | currentStatusCode={} | method={}",
						id, masterType,masterCode, action, currentStatusCode, methodName);

				return ResponseEntity.badRequest().body(Map.of("message", "Invalid input parameters"));
			}

			// Service call
			List<?> result = workFlowService.getRequestsByIdAndMasterAndActionMan(id, masterType,masterCode, action,
					currentStatusCode);

			int count = (result != null ? result.size() : 0);
			log.info("[SUCCESS] {} executed | totalRecords={} | masterType={} | action={} | statusCode={}", methodName,
					count, masterType, action, currentStatusCode);

			// Return successful response
			return ResponseEntity
					.ok(Map.of("message", "Action processed successfully", "recordsUpdated", count, "data", result));

		} catch (Exception ex) {
			log.error("[ERROR] Exception occurred in {} | id={} | masterType={} | action={} | error={}", methodName, id,
					masterType, action, ex.getMessage(), ex);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("message", "An unexpected error occurred", "error", ex.getMessage()));
		}
	}
	
	@GetMapping("/update/action/sman")
	public ResponseEntity<?> updateRequestActionSeniorMan(@RequestParam Long id, @RequestParam String masterType,@RequestParam String masterCode,
			@RequestParam String action, @RequestParam String currentStatusCode, @RequestParam String requestType ) {

		final String methodName = "updateRequestActionSeniorMan";
		log.info("[START] {} | id={} | masterType={} | action={} | statusCode={} | class={}", methodName, id,
				masterType, action, currentStatusCode, this.getClass().getSimpleName());

		try {
			// Input validation
			if (id == null || masterType == null || masterType.isBlank() || action == null || action.isBlank()
					|| currentStatusCode == null || currentStatusCode.isBlank()) {

				log.warn("Invalid request parameters | id={} | masterType={} | action={} | statusCode={} | method={}",
						id, masterType, action, currentStatusCode, methodName);

				return ResponseEntity.badRequest().body(Map.of("message", "Invalid input parameters"));
			}

			// Service call
			List<?> result = workFlowService.getRequestsByIdAndMasterAndActionSeniorMan(id, masterType,masterCode, action,
					currentStatusCode,requestType);

			int count = (result != null ? result.size() : 0);
			log.info("[SUCCESS] {} executed | totalRecords={} | masterType={} | action={} | statusCode={}", methodName,
					count, masterType, action, currentStatusCode);

			// Return successful response
			return ResponseEntity
					.ok(Map.of("message", "Action processed successfully", "recordsUpdated", count, "data", result));

		} catch (Exception ex) {
			log.error("[ERROR] Exception occurred in {} | id={} | masterType={} | action={} | error={}", methodName, id,
					masterType, action, ex.getMessage(), ex);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("message", "An unexpected error occurred", "error", ex.getMessage()));
		}
	}
	
	@GetMapping("/update/action/admin")
	public ResponseEntity<?> updateRequestActionAdmin(@RequestParam Long id, @RequestParam String masterType,@RequestParam String masterCode,
			@RequestParam String action, @RequestParam String currentStatusCode) {

		final String methodName = "updateRequestActionAdmin";
		log.info("[START] {} | id={} | masterType={} | action={} | statusCode={} | class={}", methodName, id,
				masterType, action, currentStatusCode, this.getClass().getSimpleName());

		try {
			// Input validation
			if (id == null || masterType == null || masterType.isBlank() || action == null || action.isBlank()
					|| currentStatusCode == null || currentStatusCode.isBlank()) {

				log.warn("Invalid request parameters | id={} | masterType={} | action={} | statusCode={} | method={}",
						id, masterType, action, currentStatusCode, methodName);

				return ResponseEntity.badRequest().body(Map.of("message", "Invalid input parameters"));
			}

			// Service call
			List<?> result = workFlowService.getRequestsByIdAndMasterAndActionAdmin(id, masterType,masterCode, action,
					currentStatusCode);

			int count = (result != null ? result.size() : 0);
			log.info("[SUCCESS] {} executed | totalRecords={} | masterType={} | action={} | statusCode={}", methodName,
					count, masterType, action, currentStatusCode);

			// Return successful response
			return ResponseEntity
					.ok(Map.of("message", "Action processed successfully", "recordsUpdated", count, "data", result));

		} catch (Exception ex) {
			log.error("[ERROR] Exception occurred in {} | id={} | masterType={} | action={} | error={}", methodName, id,
					masterType, action, ex.getMessage(), ex);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("message", "An unexpected error occurred", "error", ex.getMessage()));
		}
	}
	
	@GetMapping("/update/action/dc")
	public ResponseEntity<?> updateRequestActionDeputyCom(@RequestParam Long id, @RequestParam String masterType,@RequestParam String masterCode,
			@RequestParam String action, @RequestParam String currentStatusCode, @RequestParam String requestType ) {

		final String methodName = "updateRequestActionDeputyCom";
		log.info("[START] {} | id={} | masterType={} | action={} | statusCode={} | class={}", methodName, id,
				masterType, action, currentStatusCode, this.getClass().getSimpleName());

		try {
			// Input validation
			if (id == null || masterType == null || masterType.isBlank() || action == null || action.isBlank()
					|| currentStatusCode == null || currentStatusCode.isBlank()) {

				log.warn("Invalid request parameters | id={} | masterType={} | action={} | statusCode={} | method={}",
						id, masterType, action, currentStatusCode, methodName);

				return ResponseEntity.badRequest().body(Map.of("message", "Invalid input parameters"));
			}

			// Service call
			List<?> result = workFlowService.getRequestsByIdAndMasterAndActionDeputyCom(id, masterType,masterCode, action,
					currentStatusCode,requestType);

			int count = (result != null ? result.size() : 0);
			log.info("[SUCCESS] {} executed | totalRecords={} | masterType={} | action={} | statusCode={}", methodName,
					count, masterType, action, currentStatusCode);

			// Return successful response
			return ResponseEntity
					.ok(Map.of("message", "Action processed successfully", "recordsUpdated", count, "data", result));

		} catch (Exception ex) {
			log.error("[ERROR] Exception occurred in {} | id={} | masterType={} | action={} | error={}", methodName, id,
					masterType, action, ex.getMessage(), ex);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("message", "An unexpected error occurred", "error", ex.getMessage()));
		}
	}
	
	@GetMapping("/update/action/adc")
	public ResponseEntity<?> updateRequestActionAdc(@RequestParam Long id, @RequestParam String masterType,@RequestParam String masterCode,
			@RequestParam String action, @RequestParam String currentStatusCode) {

		final String methodName = "updateRequestActionAdc";
		log.info("[START] {} | id={} | masterType={} | masterCode={} | action={} | currentStatusCode={} | class={}", methodName, id,
				masterType, action, currentStatusCode, this.getClass().getSimpleName());

		try {
			// Input validation
			if (id == null || masterType == null || masterType.isBlank() || masterCode.isBlank() || action == null || action.isBlank()
					|| currentStatusCode == null || currentStatusCode.isBlank()) {

				log.warn("Invalid request parameters | id={} | masterType={} | masterCode={} | action={} | currentStatusCode={} | method={}",
						id, masterType,masterCode, action, currentStatusCode, methodName);

				return ResponseEntity.badRequest().body(Map.of("message", "Invalid input parameters"));
			}

			// Service call
			List<?> result = workFlowService.getRequestsByIdAndMasterAndActionAdc(id, masterType,masterCode, action,
					currentStatusCode);

			int count = (result != null ? result.size() : 0);
			log.info("[SUCCESS] {} executed | totalRecords={} | masterType={} | action={} | statusCode={}", methodName,
					count, masterType, action, currentStatusCode);

			// Return successful response
			return ResponseEntity
					.ok(Map.of("message", "Action processed successfully", "recordsUpdated", count, "data", result));

		} catch (Exception ex) {
			log.error("[ERROR] Exception occurred in {} | id={} | masterType={} | action={} | error={}", methodName, id,
					masterType, action, ex.getMessage(), ex);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("message", "An unexpected error occurred", "error", ex.getMessage()));
		}
	}
	
	@GetMapping("/update/action/co")
	public ResponseEntity<?> updateRequestActionCo(@RequestParam Long id, @RequestParam String masterType,@RequestParam String masterCode,
			@RequestParam String action, @RequestParam String currentStatusCode) {

		final String methodName = "updateRequestActionCo";
		log.info("[START] {} | id={} | masterType={} | action={} | statusCode={} | class={}", methodName, id,
				masterType, action, currentStatusCode, this.getClass().getSimpleName());

		try {
			// Input validation
			if (id == null || masterType == null || masterType.isBlank() || action == null || action.isBlank()
					|| currentStatusCode == null || currentStatusCode.isBlank()) {

				log.warn("Invalid request parameters | id={} | masterType={} | action={} | statusCode={} | method={}",
						id, masterType, action, currentStatusCode, methodName);

				return ResponseEntity.badRequest().body(Map.of("message", "Invalid input parameters"));
			}

			// Service call
			List<?> result = workFlowService.getRequestsByIdAndMasterAndActionCo(id, masterType,masterCode, action,
					currentStatusCode);

			int count = (result != null ? result.size() : 0);
			log.info("[SUCCESS] {} executed | totalRecords={} | masterType={} | action={} | statusCode={}", methodName,
					count, masterType, action, currentStatusCode);

			// Return successful response
			return ResponseEntity
					.ok(Map.of("message", "Action processed successfully", "recordsUpdated", count, "data", result));

		} catch (Exception ex) {
			log.error("[ERROR] Exception occurred in {} | id={} | masterType={} | action={} | error={}", methodName, id,
					masterType, action, ex.getMessage(), ex);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("message", "An unexpected error occurred", "error", ex.getMessage()));
		}
	}
	
	@GetMapping("/update/action/lra")
	public ResponseEntity<?> updateRequestActionLra(@RequestParam Long id, @RequestParam String masterType,@RequestParam String masterCode,
			@RequestParam String action, @RequestParam String currentStatusCode) {

		final String methodName = "updateRequestActionLra";
		log.info("[START] {} | id={} | masterType={} | action={} | statusCode={} | class={}", methodName, id,
				masterType, action, currentStatusCode, this.getClass().getSimpleName());

		try {
			// Input validation
			if (id == null || masterType == null || masterType.isBlank() || action == null || action.isBlank()
					|| currentStatusCode == null || currentStatusCode.isBlank()) {

				log.warn("Invalid request parameters | id={} | masterType={} | action={} | statusCode={} | method={}",
						id, masterType, action, currentStatusCode, methodName);

				return ResponseEntity.badRequest().body(Map.of("message", "Invalid input parameters"));
			}

			// Service call
			List<?> result = workFlowService.getRequestsByIdAndMasterAndActionLra(id, masterType,masterCode, action,
					currentStatusCode);

			int count = (result != null ? result.size() : 0);
			log.info("[SUCCESS] {} executed | totalRecords={} | masterType={} | action={} | statusCode={}", methodName,
					count, masterType, action, currentStatusCode);

			// Return successful response
			return ResponseEntity
					.ok(Map.of("message", "Action processed successfully", "recordsUpdated", count, "data", result));

		} catch (Exception ex) {
			log.error("[ERROR] Exception occurred in {} | id={} | masterType={} | action={} | error={}", methodName, id,
					masterType, action, ex.getMessage(), ex);

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("message", "An unexpected error occurred", "error", ex.getMessage()));
		}
	}



}