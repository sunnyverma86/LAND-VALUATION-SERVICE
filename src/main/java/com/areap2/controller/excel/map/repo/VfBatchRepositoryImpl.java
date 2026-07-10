package com.areap2.controller.excel.map.repo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.areap2.controller.excel.map.enity.VillageLandClassEntity;

@Repository
public class VfBatchRepositoryImpl implements VfBatchRepository {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(VfBatchRepositoryImpl.class);

    private final JdbcTemplate jdbcTemplate;

    public VfBatchRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final String INSERT_SQL =
            """
            INSERT INTO kau.village_land_class
            (
                excel_id,
                village,
                rural_urban,
                land_class,
                min_without_outliers,
                equivalent_minimum,
                name_of_equivalent,
                luf,
                min_equivalent_value,
                final_min_eq,
                mouza_code,
                unique_id,
                mouza_name,
                mouza_min,
                band_ratio
            )
            VALUES
            (
                ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?
            )
            """;

    @Override
    public void saveBatch(List<VillageLandClassEntity> records) {

        if (records == null || records.isEmpty()) {
            return;
        }

        jdbcTemplate.batchUpdate(
                INSERT_SQL,
                records,
                records.size(),
                (ps, record) -> {

                    ps.setString(1, record.getExcelId());
                    ps.setString(2, record.getVillage());
                    ps.setString(3, record.getRuralUrban());
                    ps.setString(4, record.getLandClass());

                    ps.setObject(5, record.getMinWithoutOutliers());
                    ps.setObject(6, record.getEquivalentMinimum());

                    ps.setString(7, record.getNameOfEquivalent());

                    ps.setObject(8, record.getLuf());
                    ps.setObject(9, record.getMinEquivalentValue());
                    ps.setObject(10, record.getFinalMinEq());

                    ps.setString(11, record.getMouzaCode());
                    ps.setString(12, record.getUniqueId());
                    ps.setString(13, record.getMouzaName());

                    ps.setObject(14, record.getMouzaMin());
                    ps.setObject(15, record.getBandRatio());

                });

        LOGGER.info("VF Batch Inserted : {}", records.size());

    }

}
