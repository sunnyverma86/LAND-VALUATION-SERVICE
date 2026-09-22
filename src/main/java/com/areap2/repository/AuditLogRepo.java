package com.areap2.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.entity.AuditLog;

@Repository
public interface AuditLogRepo extends JpaRepository<AuditLog, Long> {

	List<AuditLog> findAllByStatusCode(String statusCode);

	AuditLog findByReferenceId(Long id);

	AuditLog findByReferenceIdAndFeatureNameAndStatusCode(Long id, String featName, String statCode);

	List<AuditLog> findByReferenceIdAndFeatureName(Long id, String featName);

	AuditLog findTopByReferenceIdAndFeatureNameAndStatusCodeOrderByIdDesc(Long id, String featName, String statCode);

	List<AuditLog> findAllByReferenceId(Long refId);

	List<AuditLog> findByReferenceIdAndFeatureNameIgnoreCaseOrderByIdDesc(long genId, String featureName);

	Optional<AuditLog> findFirstByOrderByIdDesc();

	List<AuditLog> findByLoginIdAndHistoricalTableIsNotNullOrderByIdDesc(String loginId);

	// List<AuditLog> getRequestsByStatusCode(String statusCode, String masterType);
}
