package com.areap2.service.excel;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.areap2.dto.excel.SearchDtoRequest;
import com.areap2.entity.excel.external.LandDataXlsPropertyOriginal;
import com.areap2.repository.excel.external.LandDataXlsPropertyOriginalRepository;

@Service
public class LandDataService {

	@Autowired
	private LandDataXlsPropertyOriginalRepository repository;

	public LandDataXlsPropertyOriginal getLandData(SearchDtoRequest request) {

		String nic = buildNic(request);

		return repository.findByNicForPlotCodeAndFinalValueOfPlotGreaterThan(nic, BigDecimal.ZERO)
				.orElseThrow(() -> new RuntimeException("Data not found for NIC: " + nic));
	}

	// 🔥 NIC BUILD LOGIC
	private String buildNic(SearchDtoRequest req) {

		String district = lastTwo(req.getDistrictCode());
		String circle = lastTwo(req.getCircleCode());
		String mouza = lastTwo(req.getMouzaCode());
		String lot = lastTwo(req.getLotCode());

		String village = req.getVillageCode(); // full
		String dag = req.getDagNumber();

		// 🔥 FINAL NIC
		return district + "01" + circle + mouza + lot + village + dag;
	}

	// 🔥 Helper method
	private String lastTwo(String value) {
		if (value == null || value.length() < 2) {
			throw new RuntimeException("Invalid code: " + value);
		}
		return value.substring(value.length() - 2);
	}
	

	public List<LandDataXlsPropertyOriginal> getLandDataMultiple(SearchDtoRequest request) {

		String nic = buildNicMuliple(request);

		List<LandDataXlsPropertyOriginal> list = repository.findAllByNicForPlotCodeAndFinalValueOfPlotGreaterThan(nic,
				BigDecimal.ZERO);

		if (list.isEmpty()) {
			throw new RuntimeException("Data not found for NIC: " + nic);
		}

		return list;
	}

	// 🔥 NIC BUILD LOGIC
	private String buildNicMuliple(SearchDtoRequest req) {

		String district = lastTwo(req.getDistrictCode());
		String circle = lastTwo(req.getCircleCode());
		String mouza = lastTwo(req.getMouzaCode());
		String lot = lastTwo(req.getLotCode());

		String village = req.getVillageCode(); // full
		String dag = req.getDagNumber();

		return district + "01" + circle + mouza + lot + village + dag;
	}


}
