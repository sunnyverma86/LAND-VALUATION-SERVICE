package com.areap2.landtransaction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.areap2.landtransaction.entity.LandTransaction;

public interface LandTransactionRepository
        extends JpaRepository<LandTransaction, Long>, JpaSpecificationExecutor<LandTransaction> {

    Optional<LandTransaction> findByFingerprint(String fingerprint);

    boolean existsByFingerprintAndIdNot(String fingerprint, Long id);

    Page<LandTransaction> findByActiveTrue(Pageable pageable);

	List<LandTransaction> findByDistrictAndCircle(String district, String circle);

	List<LandTransaction> findByDistrictAndCircleAndMouza(String district, String circle, String mouza);
}
