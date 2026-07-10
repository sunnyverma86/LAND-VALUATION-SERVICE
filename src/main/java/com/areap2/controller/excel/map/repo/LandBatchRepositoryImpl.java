package com.areap2.controller.excel.map.repo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.LandRecordEntity;

@Repository
public class LandBatchRepositoryImpl implements LandBatchRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(LandBatchRepositoryImpl.class);

	private final JdbcTemplate jdbcTemplate;

	public LandBatchRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	private static final String INSERT_SQL = "INSERT INTO kau.land_master (" + "mouza," + "village," + "zonal_value,"
			+ "rural_urban," + "land_use," + "nh," + "dist_pwd," + "d_mjcbd," + "d_ur_mncbd," + "dis_wtr_lg,"
			+ "oil_pipeline," + "ecosensitive," + "nic," + "helper," + "plot," + "mouza_code," + "helper_code,"
			+ "district," + "circle," + "lot" + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	@Override
	public void saveBatch(List<LandRecordEntity> records) {

		if (records == null || records.isEmpty()) {
			return;
		}

		jdbcTemplate.batchUpdate(INSERT_SQL, records, records.size(), (ps, record) -> {

			ps.setString(1, record.getMouza());
			ps.setString(2, record.getVillage());
			ps.setObject(3, record.getZonalValue());

			ps.setString(4, record.getRuralUrban());
			ps.setString(5, record.getLandUse());

			ps.setObject(6, record.getNh());
			ps.setObject(7, record.getDistPwd());
			ps.setObject(8, record.getdMjcbd());
			ps.setObject(9, record.getdUrMncbd());

			ps.setString(10, record.getDisWtrLg());

			ps.setObject(11, record.getOilPipeline());
			ps.setObject(12, record.getEcosensitive());

			ps.setString(13, record.getNic());
			ps.setString(14, record.getHelper());
			ps.setString(15, record.getPlot());

			ps.setString(16, record.getMouzaCode());
			ps.setString(17, record.getHelperCode());
			ps.setString(18, record.getDistrict());

			ps.setString(19, record.getCircle());
			ps.setString(20, record.getLot());
		});

		LOGGER.info("Batch inserted successfully. Size={}", records.size());
	}

}
