package com.areap2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HistoricalLandOutputRepositoryImpl implements HistoricalLandOutputRepository {

	private final JdbcTemplate jdbcTemplate;

	public HistoricalLandOutputRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Map<String, Object>> findData(String qualifiedName, String district, String circle) {

		validateTableName(qualifiedName);

		StringBuilder sql = new StringBuilder("""
				SELECT
				    id,
				    base_value,
				    circle,
				    d_mjcbd,
				    d_mjcbd_weightage,
				    d_ur_mncbd,
				    d_ur_mncbd_weightage,
				    dis_wtr_lg,
				    dis_wtr_lg_weightage,
				    dist_pwd,
				    dist_pwd_weightage,
				    district,
				    district_minimum,
				    ecosensitive,
				    ecosensitive_weightage,
				    helper,
				    helper_code,
				    land_area,
				    land_use,
				    lot,
				    luf,
				    mf_calculated,
				    mouza,
				    mouza_code,
				    nh,
				    nh_weightage,
				    nic,
				    oil_pipeline,
				    oil_pipeline_weightage,
				    option_final,
				    option_final_sub_zonal,
				    option_final_sub_zonal_percen,
				    option_final_sub_zonal_percen_bracket,
				    option_sum_weightage,
				    option_value_one_add_weightage,
				    plot,
				    rural_urban,
				    vf_calculated,
				    village,
				    zonal_value
				FROM
				""");

		sql.append(qualifiedName);

		sql.append(" WHERE 1 = 1 ");

		List<Object> params = new ArrayList<>();

		if (district != null && !district.isBlank()) {
			sql.append(" AND LOWER(district) = LOWER(?) ");
			params.add(district.trim());
		}

		if (circle != null && !circle.isBlank()) {
			sql.append(" AND LOWER(circle) = LOWER(?) ");
			params.add(circle.trim());
		}

		sql.append(" ORDER BY id ");

		return jdbcTemplate.queryForList(sql.toString(), params.toArray());
	}

	private void validateTableName(String qualifiedName) {

		if (qualifiedName == null || qualifiedName.isBlank()) {
			throw new IllegalArgumentException("Qualified table name is required");
		}

		/*
		 * Expected format: schema.table_name
		 *
		 * Example: kau.land_master_output2026_09_21_22_40_27
		 */
		if (!qualifiedName.matches("^[a-zA-Z_][a-zA-Z0-9_]*\\.[a-zA-Z_][a-zA-Z0-9_]*$")) {

			throw new IllegalArgumentException("Invalid qualified table name: " + qualifiedName);
		}
	}

	public List<Map<String, Object>> findData(String qualifiedName, String district, String circle, String mouzaCode) {

		if (!qualifiedName.equalsIgnoreCase("kau.land_master_output")) {
			validateTableName(qualifiedName);
		}

		StringBuilder sql = new StringBuilder("""
				SELECT
				    id,
				    base_value,
				    circle,
				    d_mjcbd,
				    d_mjcbd_weightage,
				    d_ur_mncbd,
				    d_ur_mncbd_weightage,
				    dis_wtr_lg,
				    dis_wtr_lg_weightage,
				    dist_pwd,
				    dist_pwd_weightage,
				    district,
				    district_minimum,
				    ecosensitive,
				    ecosensitive_weightage,
				    helper,
				    helper_code,
				    land_area,
				    land_use,
				    lot,
				    luf,
				    mf_calculated,
				    mouza,
				    mouza_code,
				    nh,
				    nh_weightage,
				    nic,
				    oil_pipeline,
				    oil_pipeline_weightage,
				    option_final,
				    option_final_sub_zonal,
				    option_final_sub_zonal_percen,
				    option_final_sub_zonal_percen_bracket,
				    option_sum_weightage,
				    option_value_one_add_weightage,
				    plot,
				    rural_urban,
				    vf_calculated,
				    village,
				    zonal_value
				FROM
				""");

		sql.append(qualifiedName);

		sql.append(" WHERE 1 = 1 ");

		List<Object> params = new ArrayList<>();

		if (district != null && !district.isBlank()) {
			sql.append(" AND LOWER(district) = LOWER(?) ");
			params.add(district.trim());
		}

		if (circle != null && !circle.isBlank()) {
			sql.append(" AND LOWER(circle) = LOWER(?) ");
			params.add(circle.trim());
		}

		if (mouzaCode != null && !mouzaCode.isBlank()) {
			sql.append(" AND LOWER(mouza_code) = LOWER(?) ");
			params.add(mouzaCode.trim());
		}

		sql.append(" ORDER BY id ");

		return jdbcTemplate.queryForList(sql.toString(), params.toArray());
	}

}
