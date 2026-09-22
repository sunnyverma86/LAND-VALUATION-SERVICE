package com.areap2.repository;

import java.util.List;
import java.util.Map;


public interface HistoricalLandOutputRepository {

	List<Map<String, Object>> findData(String qualifiedName, String district, String circle);
}
