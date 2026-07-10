package com.areap2.repository.excel.external;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.areap2.entity.excel.external.LandDataXlsPropertyOriginal;

@Repository
public interface LandDataXlsPropertyOriginalRepository extends JpaRepository<LandDataXlsPropertyOriginal, Long> {

	Optional<LandDataXlsPropertyOriginal> findByNicForPlotCode(String nicForPlotCode);

	Optional<LandDataXlsPropertyOriginal> findByNicForPlotCodeAndFinalValueOfPlotGreaterThan(String nic,
			BigDecimal zero);

	List<LandDataXlsPropertyOriginal> findAllByNicForPlotCodeAndFinalValueOfPlotGreaterThan(String nicForPlotCode,
			BigDecimal value);
}
