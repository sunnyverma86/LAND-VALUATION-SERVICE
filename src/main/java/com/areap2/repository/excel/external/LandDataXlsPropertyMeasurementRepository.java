package com.areap2.repository.excel.external;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.entity.excel.external.LandDataXlsParameter;
import com.areap2.entity.excel.external.LandDataXlsPropertyMeasurement;

@Repository
public interface LandDataXlsPropertyMeasurementRepository extends JpaRepository<LandDataXlsPropertyMeasurement, Long> {

	Optional<LandDataXlsParameter> findByNicCodeAndTextParcel(String nicCode, String textparcel);

}
