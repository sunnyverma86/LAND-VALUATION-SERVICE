package com.areap2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.areap2.entity.AuditLog;
import com.areap2.entity.DistrictDetails;

@Service
public interface WorkFlowService {

	public List<AuditLog> getRequestsByStatusCode(String string);

	List<DistrictDetails> getDistrictRequestsByStatusCode(String statusCode);

	DistrictDetails handleJuniorManagerAction(Long id, String action);

	List<?> getRequestsByStatusCodeAndMaster(String statusCode, String masterType);

	public List<?> getRequestsByIdAndMasterAndAction(Long id, String masterType, String action, String statusCode);
	
	public List<?> getRequestsByIdAndMasterAndActionMan(Long id, String masterType, String action, String statusCode);
	
	public List<?> getRequestsByIdAndMasterAndActionSeniorMan(Long id, String masterType, String action, String statusCode);
	
	public List<?> getRequestsByIdAndMasterAndActionAdmin(Long id, String masterType, String action, String statusCode);

}
