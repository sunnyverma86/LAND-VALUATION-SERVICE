package com.areap2.service.historical;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.areap2.dto.historical.HistoricalTableResponse;
import com.areap2.entity.AuditLog;
import com.areap2.repository.AuditLogRepo;
import com.areap2.repository.HistoricalLandOutputRepositoryImpl;
import com.areap2.repository.historical.HistoricalLandOutputRepository;

@Service
@Transactional
public class HistoricalLandOutputServiceImpl implements HistoricalLandOutputService {

	@Autowired
	private HistoricalLandOutputRepositoryImpl historicalLandOutputRepositoryImpl;

	@Autowired
	private AuditLogRepo auditLogRepo;

	@Autowired
	private HistoricalLandOutputRepository repository;

	public List<Map<String, Object>> findData(String qualifiedName, String district, String circle) {

		return historicalLandOutputRepositoryImpl.findData(qualifiedName, district, circle);
	}

	public List<Map<String, Object>> findData(String qualifiedName, String district, String circle, String mouzaCode) {
		return historicalLandOutputRepositoryImpl.findData(qualifiedName, district, circle, mouzaCode);
	}

	private static final String SCHEMA = "kau";
	private static final Pattern TABLE_PATTERN = Pattern
			.compile("^land_master_output\\d{4}_\\d{2}_\\d{2}_\\d{2}_\\d{2}_\\d{2}$");
	private static final Set<String> COLUMNS = Set.of("base_value", "circle", "d_mjcbd", "d_mjcbd_weightage",
			"d_ur_mncbd", "d_ur_mncbd_weightage", "dis_wtr_lg", "dis_wtr_lg_weightage", "dist_pwd",
			"dist_pwd_weightage", "district", "district_minimum", "ecosensitive", "ecosensitive_weightage", "helper",
			"helper_code", "land_area", "land_use", "lot", "luf", "mf_calculated", "mouza", "mouza_code", "nh",
			"nh_weightage", "nic", "oil_pipeline", "oil_pipeline_weightage", "option_final", "option_final_sub_zonal",
			"option_final_sub_zonal_percen", "option_final_sub_zonal_percen_bracket", "option_sum_weightage",
			"option_value_one_add_weightage", "plot", "rural_urban", "vf_calculated", "village", "zonal_value");

	private String table(String loginId, String tableName) {
		if (loginId == null || loginId.isBlank())
			throw new IllegalArgumentException("loginId is required");
		if (tableName == null || !TABLE_PATTERN.matcher(tableName).matches())
			throw new IllegalArgumentException("Invalid historical table name");
		boolean permitted = auditLogRepo.findByLoginIdAndHistoricalTableIsNotNullOrderByIdDesc(loginId).stream()
				.map(AuditLog::getHistoricalTable).filter(Objects::nonNull)
				.anyMatch(t -> t.equals(tableName) || t.equals(SCHEMA + "." + tableName));
		if (!permitted)
			throw new IllegalArgumentException("The selected historical table is not available for this loginId");
		return SCHEMA + "." + tableName;
	}

	private Map<String, Object> clean(Map<String, Object> input) {
		if (input == null || input.isEmpty())
			throw new IllegalArgumentException("At least one field is required");
		Map<String, Object> clean = new LinkedHashMap<>();
		input.forEach((key, value) -> {
			if (!COLUMNS.contains(key))
				throw new IllegalArgumentException("Unsupported column: " + key);
			clean.put(key, value);
		});
		return clean;
	}

	@Override
	public List<HistoricalTableResponse> tablesForLogin(String loginId) {

		return auditLogRepo.findByLoginIdAndHistoricalTableIsNotNullOrderByIdDesc(loginId).stream()
				.filter(a -> a.getHistoricalTable() != null).map(a -> {

					String tableName = a.getHistoricalTable();

					if (tableName.startsWith(SCHEMA + ".")) {
						tableName = tableName.substring(SCHEMA.length() + 1);
					}

					LocalDateTime actionDatetime = null;

					if (a.getActionDatetime() != null) {
						actionDatetime = a.getActionDatetime().toLocalDateTime();
					}

					return new HistoricalTableResponse(tableName, SCHEMA, SCHEMA + "." + tableName, actionDatetime,
							a.getActionType());
				}).filter(r -> TABLE_PATTERN.matcher(r.getTableName()).matches()).distinct().toList();
	}

	@Override
	public List<Map<String, Object>> findAll(String loginId, String tableName) {
		return repository.findAll(table(loginId, tableName));
	}

	@Override
	public Map<String, Object> findById(String loginId, String tableName, long id) {
		Map<String, Object> row = repository.findById(table(loginId, tableName), id);
		if (row == null)
			throw new NoSuchElementException("Record not found: " + id);
		return row;
	}

	@Override
	public Map<String, Object> create(String loginId, String tableName, Map<String, Object> values) {
		String table = table(loginId, tableName);
		Map<String, Object> clean = clean(values);
		long id = repository.insert(table, clean);
		return repository.findById(table, id);
	}

	@Override
	public Map<String, Object> update(String loginId, String tableName, long id, Map<String, Object> values) {
		String table = table(loginId, tableName);
		Map<String, Object> clean = clean(values);
		if (repository.update(table, id, clean) == 0)
			throw new NoSuchElementException("Record not found: " + id);
		return repository.findById(table, id);
	}

	@Override
	public void delete(String loginId, String tableName, long id) {
		if (repository.delete(table(loginId, tableName), id) == 0)
			throw new NoSuchElementException("Record not found: " + id);
	}
	
	
}
