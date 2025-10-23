package com.areap2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.entity.AuditLog;

@Repository
public interface AuditLogRepo extends JpaRepository<AuditLog, Long> {

	List<AuditLog> findAllByStatusCode(String statusCode);

	AuditLog findByReferenceId(Long id);

	AuditLog findByReferenceIdAndFeatureNameAndStatusCode(Long id, String featName, String statCode);

	//List<AuditLog> getRequestsByStatusCode(String statusCode, String masterType);
}
