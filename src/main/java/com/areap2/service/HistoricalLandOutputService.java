package com.areap2.service;

import java.util.List;
import java.util.Map;

public interface HistoricalLandOutputService {

	List<Map<String, Object>> findData(String qualifiedName, String district, String circle);
}
