package com.areap2.controller.excel.map.repo;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.LandUseFactorExcelEntity;

@Repository
public class LufBatchRepositoryImpl implements LufBatchRepository {

	private final JdbcTemplate jdbcTemplate;

	public LufBatchRepositoryImpl(JdbcTemplate jdbcTemplate) {

		this.jdbcTemplate = jdbcTemplate;
	}

	private static final String INSERT_SQL = """
			INSERT INTO kau.land_use_factor_excel
			(
			    land_use,
			    rural_urban,
			    luf
			)
			VALUES
			(
			    ?,?,?
			)
			""";

	@Override
	public void saveBatch(List<LandUseFactorExcelEntity> records) {

		jdbcTemplate.batchUpdate(

				INSERT_SQL,

				records,

				records.size(),

				(ps, record) -> {

					ps.setString(1, record.getLandUse());

					ps.setString(2, record.getRuralUrban());

					ps.setObject(3, record.getLuf());

				});

	}

}
