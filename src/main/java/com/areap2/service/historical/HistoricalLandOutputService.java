package com.areap2.service.historical;

import java.util.List;
import java.util.Map;

import com.areap2.dto.historical.HistoricalTableResponse;

public interface HistoricalLandOutputService {
    List<HistoricalTableResponse> tablesForLogin(String loginId);
    List<Map<String,Object>> findAll(String loginId, String tableName);
    Map<String,Object> findById(String loginId, String tableName, long id);
    Map<String,Object> create(String loginId, String tableName, Map<String,Object> values);
    Map<String,Object> update(String loginId, String tableName, long id, Map<String,Object> values);
    void delete(String loginId, String tableName, long id);
}
