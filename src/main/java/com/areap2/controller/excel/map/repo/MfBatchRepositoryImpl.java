package com.areap2.controller.excel.map.repo;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.MouzaFactorBaseDatabase;



@Repository
public class MfBatchRepositoryImpl implements MouzaFactorBaseDatabaseRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(MfBatchRepositoryImpl.class);

	private final JdbcTemplate jdbcTemplate;

	public MfBatchRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final String INSERT_SQL = """
			INSERT INTO kau.mf_calculation
			(
			    mouza,
			    rural_urban,
			    land_use,
			    min_excl,
			    higher_land_class_min,
			    lc,
			    luf,
			    district_minimum,
			    current,
			    final_mf_zonal_value
			)
			VALUES
			(
			    ?,?,?,?,?,?,?,?,?,?
			)
			""";


	public void saveBatch(List<MouzaFactorBaseDatabase> records) {

		if (records == null || records.isEmpty()) {
			return;
		}

		jdbcTemplate.batchUpdate(INSERT_SQL, records, records.size(), (ps, record) -> {

			ps.setString(1, record.getMouza());
			ps.setString(2, record.getRuralUrban());
			ps.setString(3, record.getLandUse());

			ps.setObject(4, record.getMinExcl());
			ps.setObject(5, record.getHigherLandClassMin());
			ps.setObject(6, record.getLc());
			ps.setObject(7, record.getLuf());
			ps.setObject(8, record.getDistrictMinimum());
			ps.setObject(9, record.getCurrent());
			ps.setObject(10, record.getFinalMfZonalValue());

		});

		LOGGER.info("MF Batch Inserted : {}", records.size());

	}

}