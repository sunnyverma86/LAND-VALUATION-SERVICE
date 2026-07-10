package com.areap2.controller.excel.map.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.areap2.controller.excel.map.enity.BaseParameterDetails;
import com.areap2.controller.excel.map.enity.DistrictMinimumBaseDatabase;
import com.areap2.controller.excel.map.enity.LandUseFactorExcelEntity;
import com.areap2.controller.excel.map.enity.LandUseMaster;
import com.areap2.controller.excel.map.enity.MouzaFactorBaseDatabase;
import com.areap2.controller.excel.map.enity.VillageLandClassEntity;
import com.areap2.controller.excel.map.enity.band.DistrictParameterMaster;
import com.areap2.controller.excel.map.service.BaseParameterDetailsService;
import com.areap2.controller.excel.map.service.DistrictMinimumBaseDatabaseServiceImpl;
import com.areap2.controller.excel.map.service.DistrictParameterServiceImpl;
import com.areap2.controller.excel.map.service.LandOutputService;
import com.areap2.controller.excel.map.service.LandUseFactorExcelServiceImpl;
import com.areap2.controller.excel.map.service.LandUseMasterService;
import com.areap2.controller.excel.map.service.MouzaFactorJpaServiceImpl;
import com.areap2.controller.excel.map.service.VillageLandClassServiceImpl;
import com.areap2.model.ResponseModel;

@RestController
@RequestMapping("/api/v1/district-base")
public class MasterBaseController {

	Logger log = LoggerFactory.getLogger(MasterBaseController.class);

	@Autowired
	private VillageLandClassServiceImpl villageLandClassServiceImpl;

	@Autowired
	private DistrictMinimumBaseDatabaseServiceImpl districtMinimumBaseDatabaseService;

	@Autowired
	private LandUseFactorExcelServiceImpl landUseFactorExcelService;

	@Autowired
	private LandUseMasterService landUseMasterService;

	@Autowired
	private MouzaFactorJpaServiceImpl mouzaFactorJpaServiceImpl;

	@Autowired
	private BaseParameterDetailsService baseParameterDetailsService;

	@Autowired
	private DistrictParameterServiceImpl bandParameterServiceImpl;

	@Autowired
	private LandOutputService landOutputService;

	// dm
	@PostMapping("/saveDistrictMinimumBaseDatabase")
	public ResponseModel saveDistrictMinimumBaseDatabase(@RequestBody DistrictMinimumBaseDatabase request) {

		final String methodName = "saveDistrictMinimumBaseDatabase";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}]", methodName, className);

		long startTime = System.currentTimeMillis();

		try {

			response = districtMinimumBaseDatabaseService.save(request);

			log.info("[SUCCESS] [{}] - {}", methodName, response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] {}", methodName, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());
		}

		log.info("[END] [{}] Duration : {} ms", methodName, (System.currentTimeMillis() - startTime));

		return response;
	}

	@GetMapping("/getDistrictMinimumBaseDatabaseById")
	public ResponseModel getDistrictMinimumBaseDatabaseById(@RequestParam Long id) {

		final String methodName = "getDistrictMinimumBaseDatabaseById";
		final String className = this.getClass().getSimpleName();

		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}] | Id : {}", methodName, className, id);

		long startTime = System.currentTimeMillis();

		try {

			response = districtMinimumBaseDatabaseService.getById(id);

			log.info("[SUCCESS] [{}] - {}", methodName, response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] - {}", methodName, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());
		}

		log.info("[END] [{}] Duration : {} ms", methodName, (System.currentTimeMillis() - startTime));

		return response;
	}

	@DeleteMapping("/deleteDistrictMinimumBaseDatabase")
	public ResponseModel deleteDistrictMinimumBaseDatabase(@RequestParam Long id) {

		final String methodName = "deleteDistrictMinimumBaseDatabase";
		final String className = this.getClass().getSimpleName();

		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}] | Id : {}", methodName, className, id);

		long startTime = System.currentTimeMillis();

		try {

			response = districtMinimumBaseDatabaseService.delete(id);

			log.info("[SUCCESS] [{}] - {}", methodName, response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] - {}", methodName, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());
		}

		log.info("[END] [{}] Duration : {} ms", methodName, (System.currentTimeMillis() - startTime));

		return response;
	}

	@GetMapping("/getAllDistrictMinimumBaseDatabase")
	public ResponseModel getAllDistrictMinimumBaseDatabase() {

		final String methodName = "getAllDistrictMinimumBaseDatabase";
		final String className = this.getClass().getSimpleName();

		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}]", methodName, className);

		long startTime = System.currentTimeMillis();

		try {

			response = districtMinimumBaseDatabaseService.getAll();

			log.info("[SUCCESS] [{}] - {}", methodName, response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] - {}", methodName, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());
		}

		log.info("[END] [{}] Duration : {} ms", methodName, (System.currentTimeMillis() - startTime));

		return response;
	}

	@PutMapping("/updateDistrictMinimumBaseDatabase")
	public ResponseModel updateDistrictMinimumBaseDatabase(@RequestParam Long id,
			@RequestBody DistrictMinimumBaseDatabase request) {

		final String methodName = "updateDistrictMinimumBaseDatabase";
		final String className = this.getClass().getSimpleName();
		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}] | Id : {}", methodName, className, id);

		long startTime = System.currentTimeMillis();

		try {

			log.debug("[PROCESS] [{}] - Updating District Minimum Base Database | Id : {}", methodName, id);

			response = districtMinimumBaseDatabaseService.update(id, request);

			log.info("[SUCCESS] [{}] - Status : {} | Message : {}", methodName, response.getHttpStatus(),
					response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] - Exception occurred in [{}] | Id : {} | Error : {}", methodName, className, id,
					e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage("Failed to update record. Reason : " + e.getLocalizedMessage());
		}

		long endTime = System.currentTimeMillis();

		log.info("[END] [{}] - Completed in [{}] | Duration : {} ms", methodName, className, (endTime - startTime));

		return response;
	}

//luf
	@PostMapping("/land-use-factor/save")
	public ResponseModel saveLandUseFactor(@RequestBody LandUseFactorExcelEntity request) {

		ResponseModel response = new ResponseModel();

		try {

			response = landUseFactorExcelService.save(request);

		} catch (Exception e) {

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());
		}

		return response;
	}

	@GetMapping("/land-use-factor/getAll")
	public ResponseModel getAllLandUseFactor() {

		return landUseFactorExcelService.getAll();
	}

	@GetMapping("/land-use-factor/getById/{id}")
	public ResponseModel getByIdLandUseFactor(@PathVariable Long id) {

		return landUseFactorExcelService.getById(id);
	}

	@PutMapping("/land-use-factor/update/{id}")
	public ResponseModel updateLandUseFactor(@PathVariable Long id, @RequestBody LandUseFactorExcelEntity request) {

		ResponseModel response = new ResponseModel();

		try {

			response = landUseFactorExcelService.update(id, request);

		} catch (Exception e) {

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());
		}

		return response;
	}

	@DeleteMapping("/land-use-factor/delete/{id}")
	public ResponseModel deleteLandUseFactor(@PathVariable Long id) {

		ResponseModel response = new ResponseModel();

		try {

			response = landUseFactorExcelService.delete(id);

		} catch (Exception e) {

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());
		}

		return response;
	}

	@PostMapping("/landuse/save")
	public LandUseMaster save(@RequestBody LandUseMaster landUseMaster) {
		return landUseMasterService.save(landUseMaster);
	}

	@GetMapping("/landuse/get-all")
	public List<LandUseMaster> getAll() {
		return landUseMasterService.getAll();
	}

	@GetMapping("/landuse/get-by-id/{id}")
	public LandUseMaster getById(@PathVariable Long id) {
		return landUseMasterService.getById(id);
	}

	@PutMapping("landuse/update-by-id/{id}")
	public LandUseMaster update(@PathVariable Long id, @RequestBody LandUseMaster landUseMaster) {
		return landUseMasterService.update(id, landUseMaster);
	}

	@DeleteMapping("landuse/delete/{id}")
	public String delete(@PathVariable Long id) {
		landUseMasterService.delete(id);
		return "Land Use deleted successfully";
	}

	// mf---MouzaFactor mouzaFactorJpaServiceImpl

	@PostMapping("/save-mouza-factor")
	public ResponseModel saveMouzaFactor(@RequestBody MouzaFactorBaseDatabase request) {

		final String methodName = "save";
		final String className = this.getClass().getSimpleName();

		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}]", methodName, className);

		long startTime = System.currentTimeMillis();

		try {

			response = mouzaFactorJpaServiceImpl.save(request);

			log.info("[SUCCESS] [{}] - {}", methodName, response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] {}", methodName, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());
		}

		log.info("[END] [{}] Duration : {} ms", methodName, (System.currentTimeMillis() - startTime));

		return response;
	}

	@GetMapping("/get-all-mouza-factor")
	public ResponseModel getAllMouzaFactor() {

		final String methodName = "getAll";
		final String className = this.getClass().getSimpleName();

		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}]", methodName, className);

		long startTime = System.currentTimeMillis();

		try {

			response = mouzaFactorJpaServiceImpl.getAll();

			log.info("[SUCCESS] [{}] - {}", methodName, response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] {}", methodName, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());
		}

		log.info("[END] [{}] Duration : {} ms", methodName, (System.currentTimeMillis() - startTime));

		return response;
	}

	@GetMapping("/get-allwith-inactive-mouza-factor")
	public ResponseModel getAllwithInactiveMouzaFactor() {

		final String methodName = "getAllwithInactive";
		final String className = this.getClass().getSimpleName();

		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}]", methodName, className);

		long startTime = System.currentTimeMillis();

		try {

			response = mouzaFactorJpaServiceImpl.getAllWithInactive();

			log.info("[SUCCESS] [{}] - {}", methodName, response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] {}", methodName, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());
		}

		log.info("[END] [{}] Duration : {} ms", methodName, (System.currentTimeMillis() - startTime));

		return response;
	}

	@GetMapping("/get-by-id-mouza-factor/{id}")
	public ResponseModel getByIdMouzaFactor(@PathVariable Long id) {

		final String methodName = "getById";
		final String className = this.getClass().getSimpleName();

		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}]", methodName, className);

		long startTime = System.currentTimeMillis();

		try {

			response = mouzaFactorJpaServiceImpl.getById(id);

			log.info("[SUCCESS] [{}] - {}", methodName, response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] {}", methodName, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());
		}

		log.info("[END] [{}] Duration : {} ms", methodName, (System.currentTimeMillis() - startTime));

		return response;
	}

	@PutMapping("/update-mouza-factor/{id}")
	public ResponseModel updateMouzaFactor(@PathVariable Long id, @RequestBody MouzaFactorBaseDatabase request) {

		final String methodName = "update";
		final String className = this.getClass().getSimpleName();

		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}]", methodName, className);

		long startTime = System.currentTimeMillis();

		try {

			response = mouzaFactorJpaServiceImpl.update(id, request);

			log.info("[SUCCESS] [{}] - {}", methodName, response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] {}", methodName, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());
		}

		log.info("[END] [{}] Duration : {} ms", methodName, (System.currentTimeMillis() - startTime));

		return response;
	}

	@DeleteMapping("/delete-mouza-factor/{id}")
	public ResponseModel deleteMouzaFactor(@PathVariable Long id) {

		final String methodName = "delete";
		final String className = this.getClass().getSimpleName();

		ResponseModel response = new ResponseModel();

		log.info("[START] [{}] - Invoked in [{}]", methodName, className);

		long startTime = System.currentTimeMillis();

		try {

			response = mouzaFactorJpaServiceImpl.delete(id);

			log.info("[SUCCESS] [{}] - {}", methodName, response.getMessage());

		} catch (Exception e) {

			log.error("[ERROR] [{}] {}", methodName, e.getMessage(), e);

			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());
		}

		log.info("[END] [{}] Duration : {} ms", methodName, (System.currentTimeMillis() - startTime));

		return response;
	}

	// ---VILLAGE FACTOR------>

	@PostMapping("/save-village-factor")
	public ResponseModel saveVillageFactor(@RequestBody VillageLandClassEntity request) {

		try {
			return villageLandClassServiceImpl.save(request);
		} catch (Exception e) {

			ResponseModel response = new ResponseModel();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());

			log.error("Save Error", e);

			return response;
		}
	}

	@GetMapping("/get-all-village-factor")
	public ResponseModel getAllVillageFactor() {

		try {
			return villageLandClassServiceImpl.getAll();
		} catch (Exception e) {

			ResponseModel response = new ResponseModel();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());

			log.error("GetAll Error", e);

			return response;
		}
	}

	@GetMapping("/get-all-with-inactive-village-factor")
	public ResponseModel getAllWithInactiveVillageFactor() {

		try {
			return villageLandClassServiceImpl.getAllWithInactive();
		} catch (Exception e) {

			ResponseModel response = new ResponseModel();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());

			log.error("GetAllWithInactive Error", e);

			return response;
		}
	}

	@GetMapping("/get-by-id-village-factor/{id}")
	public ResponseModel getByIdVillageFactor(@PathVariable Long id) {

		try {
			return villageLandClassServiceImpl.getById(id);
		} catch (Exception e) {

			ResponseModel response = new ResponseModel();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());

			log.error("GetById Error", e);

			return response;
		}
	}

	@PutMapping("/update-village-factor/{id}")
	public ResponseModel updateVillageFactor(@PathVariable Long id, @RequestBody VillageLandClassEntity request) {

		try {
			return villageLandClassServiceImpl.update(id, request);
		} catch (Exception e) {

			ResponseModel response = new ResponseModel();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());

			log.error("Update Error", e);

			return response;
		}
	}

	@DeleteMapping("/delete-village-factor/{id}")
	public ResponseModel deleteVillageFactor(@PathVariable Long id) {

		try {
			return villageLandClassServiceImpl.delete(id);
		} catch (Exception e) {

			ResponseModel response = new ResponseModel();
			response.setHttpStatus(HttpStatus.EXPECTATION_FAILED);
			response.setMessage(e.getLocalizedMessage());

			log.error("Delete Error", e);

			return response;
		}
	}

	// parameters
	@PostMapping("/save-base-parameter-details")
	public BaseParameterDetails saveBaseParameterDetails(@RequestBody BaseParameterDetails entity) {
		return baseParameterDetailsService.save(entity);
	}

	@GetMapping("/get-all-base-parameter-details")
	public List<BaseParameterDetails> getAllBaseParameterDetails() {
		return baseParameterDetailsService.getAll();
	}

	@GetMapping("/get-base-parameter-details/{id}")
	public BaseParameterDetails getByIdBaseParameterDetails(@PathVariable Long id) {
		return baseParameterDetailsService.getById(id);
	}

	@PutMapping("/update-base-parameter-details/{id}")
	public BaseParameterDetails updateBaseParameterDetails(@PathVariable Long id,
			@RequestBody BaseParameterDetails entity) {
		return baseParameterDetailsService.update(id, entity);
	}

	@DeleteMapping("delete-base-parameter-details/{id}")
	public String deleteBaseParameterDetails(@PathVariable Long id) {
		baseParameterDetailsService.delete(id);
		return "Record deleted successfully";
	}

	// band
	@PostMapping("/band-parameter-save")
	public DistrictParameterMaster saveBandParameter(@RequestBody DistrictParameterMaster entity) {

		return bandParameterServiceImpl.save(entity);
	}

	@GetMapping("/band-parameter-list")
	public List<DistrictParameterMaster> getAllBandParameter() {

		return bandParameterServiceImpl.getAll();
	}

	@GetMapping("/band-parameter/{id}")
	public DistrictParameterMaster getByIdBandParameter(@PathVariable Long id) {

		return bandParameterServiceImpl.getById(id);
	}

	@PutMapping("/band-parameter-update/{id}")
	public DistrictParameterMaster updateBandParameter(@PathVariable Long id,
			@RequestBody DistrictParameterMaster entity) {

		DistrictParameterMaster out = bandParameterServiceImpl.update(id, entity);
		//landOutputService.generateOutputTable();
		return out;
	}

	@DeleteMapping("/band-parameter-delete/{id}")
	public String deleteBandParameter(@PathVariable Long id) {

		bandParameterServiceImpl.delete(id);

		return "Deleted Successfully";
	}

}
