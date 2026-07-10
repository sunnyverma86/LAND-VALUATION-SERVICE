package com.areap2.controller.excel.map.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LandOutputService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LandOutputService.class);

	@Autowired
	private JdbcTemplate dd;
	String sql = """
			INSERT INTO kau.land_master_output
												(
												    mouza,
												    village,
												    zonal_value,
												    rural_urban,
												    land_use,
												    nh,
												    dist_pwd,
												    d_mjcbd,
												    d_ur_mncbd,
												    dis_wtr_lg,
												    oil_pipeline,
												    ecosensitive,
												    nic,
												    helper,
												    plot,
												    mouza_code,
												    helper_code,
												    district,
												    
												    circle,
												    lot,

												    district_minimum,
												    mf_calculated,
												    luf,
												    vf_calculated,
												    base_value,

												    nh_weightage,
												    dist_pwd_weightage,
												    d_mjcbd_weightage,
												    d_ur_mncbd_weightage,
												    dis_wtr_lg_weightage,
												    oil_pipeline_weightage,
												    ecosensitive_weightage,
												    option_sum_weightage,
												    option_value_one_add_weightage,
												    option_final,
													option_final_sub_zonal,
													option_final_sub_zonal_percen,
													option_final_sub_zonal_percen_bracket
												)

												SELECT

												    lm.mouza,
												    lm.village,
												    lm.zonal_value,
												    lm.rural_urban,
												    lm.land_use,
												    lm.nh,
												    lm.dist_pwd,
												    lm.d_mjcbd,
												    lm.d_ur_mncbd,
												    lm.dis_wtr_lg,
												    lm.oil_pipeline,
												    lm.ecosensitive,
												    lm.nic,
												    lm.helper,
												    lm.plot,
												    lm.mouza_code,
												    lm.helper_code,
												    lm.district,
												    lm.circle,
												    lm.lot,
												    

												    CASE
												        WHEN lm.rural_urban='R'
												            THEN rural_min.min_value
												        WHEN lm.rural_urban='U'
												            THEN urban_min.min_value
												    END AS district_minimum,

												    mf.current AS mf_calculated,

												    luf.luf AS luf,

												    vlc.band_ratio AS vf_calculated,

												    (
												        COALESCE(mf.current,0)
												        *
												        COALESCE(luf.luf,0)
												        *
												        COALESCE(
												            CASE
												                WHEN lm.rural_urban='R'
												                    THEN rural_min.min_value
												                WHEN lm.rural_urban='U'
												                    THEN urban_min.min_value
												            END,
												            0
												        )
												        *
												        COALESCE(vlc.band_ratio,0)
												    ) AS base_value,

									COALESCE(nh.weightage,0) AS nh_weightage,

									COALESCE(pwd.weightage,0) AS dist_pwd_weightage,

									COALESCE(mj.weightage,0) AS d_mjcbd_weightage,

									COALESCE(mn.weightage,0) AS d_ur_mncbd_weightage,

									0 AS dis_wtr_lg_weightage,

									COALESCE(oil.weightage,0) AS oil_pipeline_weightage,

									COALESCE(eco.weightage,0) AS ecosensitive_weightage,

									(
									    COALESCE(nh.weightage,0)
									    + COALESCE(pwd.weightage,0)
									    + COALESCE(mj.weightage,0)
									    + COALESCE(mn.weightage,0)
									    + 0
									    + COALESCE(oil.weightage,0)
									    + COALESCE(eco.weightage,0)
									) AS option_sum_weightage,

									(
						    COALESCE(nh.weightage,0)
						    + COALESCE(pwd.weightage,0)
						    + COALESCE(mj.weightage,0)
						    + COALESCE(mn.weightage,0)
						    + 0
						    + COALESCE(oil.weightage,0)
						    + COALESCE(eco.weightage,0)
						    + 1
						) AS option_value_one_add_weightage,

						(
			    (
			        COALESCE(nh.weightage,0)
			        + COALESCE(pwd.weightage,0)
			        + COALESCE(mj.weightage,0)
			        + COALESCE(mn.weightage,0)
			        + 0
			        + COALESCE(oil.weightage,0)
			        + COALESCE(eco.weightage,0)
			        + 1
			    )
			    *
			    (
			        COALESCE(mf.current,0)
			        * COALESCE(luf.luf,0)
			        * COALESCE(
			            CASE
			                WHEN lm.rural_urban='R'
			                    THEN rural_min.min_value
			                WHEN lm.rural_urban='U'
			                    THEN urban_min.min_value
			            END,
			            0
			        )
			        * COALESCE(vlc.band_ratio,0)
			    )
			) AS option_final,

			(
			    (
			        (
			            COALESCE(nh.weightage,0)
			            + COALESCE(pwd.weightage,0)
			            + COALESCE(mj.weightage,0)
			            + COALESCE(mn.weightage,0)
			            + 0
			            + COALESCE(oil.weightage,0)
			            + COALESCE(eco.weightage,0)
			            + 1
			        )
			        *
			        (
			            COALESCE(mf.current,0)
			            * COALESCE(luf.luf,0)
			            * COALESCE(
			                CASE
			                    WHEN lm.rural_urban='R'
			                        THEN rural_min.min_value
			                    WHEN lm.rural_urban='U'
			                        THEN urban_min.min_value
			                END,
			                0
			            )
			            * COALESCE(vlc.band_ratio,0)
			        )
			    )
			    - lm.zonal_value
			) AS option_final_sub_zonal,

			(
			    (
			        (
			            (
			                COALESCE(nh.weightage,0)
			                + COALESCE(pwd.weightage,0)
			                + COALESCE(mj.weightage,0)
			                + COALESCE(mn.weightage,0)
			                + 0
			                + COALESCE(oil.weightage,0)
			                + COALESCE(eco.weightage,0)
			                + 1
			            )
			            *
			            (
			                COALESCE(mf.current,0)
			                * COALESCE(luf.luf,0)
			                * COALESCE(
			                    CASE
			                        WHEN lm.rural_urban='R'
			                            THEN rural_min.min_value
			                        WHEN lm.rural_urban='U'
			                            THEN urban_min.min_value
			                    END,
			                    0
			                )
			                * COALESCE(vlc.band_ratio,0)
			            )
			        )
			        - lm.zonal_value
			    )
			    / NULLIF(lm.zonal_value,0)
			) AS option_final_sub_zonal_percen,
			CASE
    WHEN ABS(
        (
            (
                (
                    COALESCE(nh.weightage,0)
                    + COALESCE(pwd.weightage,0)
                    + COALESCE(mj.weightage,0)
                    + COALESCE(mn.weightage,0)
                    + 0
                    + COALESCE(oil.weightage,0)
                    + COALESCE(eco.weightage,0)
                    + 1
                )
                *
                (
                    COALESCE(mf.current,0)
                    * COALESCE(luf.luf,0)
                    * COALESCE(
                        CASE
                            WHEN lm.rural_urban='R' THEN rural_min.min_value
                            WHEN lm.rural_urban='U' THEN urban_min.min_value
                        END,
                        0
                    )
                    * COALESCE(vlc.band_ratio,0)
                )
            )
            - lm.zonal_value
        )
        / NULLIF(lm.zonal_value,0)
    ) <= 0.05 THEN '+/- 5%'

    WHEN ABS(
        (
            (
                (
                    COALESCE(nh.weightage,0)
                    + COALESCE(pwd.weightage,0)
                    + COALESCE(mj.weightage,0)
                    + COALESCE(mn.weightage,0)
                    + 0
                    + COALESCE(oil.weightage,0)
                    + COALESCE(eco.weightage,0)
                    + 1
                )
                *
                (
                    COALESCE(mf.current,0)
                    * COALESCE(luf.luf,0)
                    * COALESCE(
                        CASE
                            WHEN lm.rural_urban='R' THEN rural_min.min_value
                            WHEN lm.rural_urban='U' THEN urban_min.min_value
                        END,
                        0
                    )
                    * COALESCE(vlc.band_ratio,0)
                )
            )
            - lm.zonal_value
        )
        / NULLIF(lm.zonal_value,0)
    ) <= 0.10 THEN '+/- 10%'

    WHEN ABS(
        (
            (
                (
                    COALESCE(nh.weightage,0)
                    + COALESCE(pwd.weightage,0)
                    + COALESCE(mj.weightage,0)
                    + COALESCE(mn.weightage,0)
                    + 0
                    + COALESCE(oil.weightage,0)
                    + COALESCE(eco.weightage,0)
                    + 1
                )
                *
                (
                    COALESCE(mf.current,0)
                    * COALESCE(luf.luf,0)
                    * COALESCE(
                        CASE
                            WHEN lm.rural_urban='R' THEN rural_min.min_value
                            WHEN lm.rural_urban='U' THEN urban_min.min_value
                        END,
                        0
                    )
                    * COALESCE(vlc.band_ratio,0)
                )
            )
            - lm.zonal_value
        )
        / NULLIF(lm.zonal_value,0)
    ) <= 0.15 THEN '+/- 15%'

    WHEN ABS(
        (
            (
                (
                    COALESCE(nh.weightage,0)
                    + COALESCE(pwd.weightage,0)
                    + COALESCE(mj.weightage,0)
                    + COALESCE(mn.weightage,0)
                    + 0
                    + COALESCE(oil.weightage,0)
                    + COALESCE(eco.weightage,0)
                    + 1
                )
                *
                (
                    COALESCE(mf.current,0)
                    * COALESCE(luf.luf,0)
                    * COALESCE(
                        CASE
                            WHEN lm.rural_urban='R' THEN rural_min.min_value
                            WHEN lm.rural_urban='U' THEN urban_min.min_value
                        END,
                        0
                    )
                    * COALESCE(vlc.band_ratio,0)
                )
            )
            - lm.zonal_value
        )
        / NULLIF(lm.zonal_value,0)
    ) <= 0.20 THEN '+/- 20%'

    WHEN ABS(
        (
            (
                (
                    COALESCE(nh.weightage,0)
                    + COALESCE(pwd.weightage,0)
                    + COALESCE(mj.weightage,0)
                    + COALESCE(mn.weightage,0)
                    + 0
                    + COALESCE(oil.weightage,0)
                    + COALESCE(eco.weightage,0)
                    + 1
                )
                *
                (
                    COALESCE(mf.current,0)
                    * COALESCE(luf.luf,0)
                    * COALESCE(
                        CASE
                            WHEN lm.rural_urban='R' THEN rural_min.min_value
                            WHEN lm.rural_urban='U' THEN urban_min.min_value
                        END,
                        0
                    )
                    * COALESCE(vlc.band_ratio,0)
                )
            )
            - lm.zonal_value
        )
        / NULLIF(lm.zonal_value,0)
    ) <= 0.30 THEN '+/- 30%'

    ELSE 'Beyond +/- 30%'
END AS option_final_sub_zonal_percen_bracket
												FROM kau.land_master lm

												LEFT JOIN kau.district_parameter_master nh
												       ON TRIM(nh.district) = TRIM(lm.district)
												      AND TRIM(nh.rural_urban) = TRIM(lm.rural_urban)
												      AND nh.parameter_name = 'NH'
												      AND lm.nh BETWEEN nh.distance_from AND nh.distance_to
												      AND nh.perpetual = true

												LEFT JOIN kau.district_parameter_master pwd
												       ON TRIM(pwd.district) = TRIM(lm.district)
												      AND TRIM(pwd.rural_urban) = TRIM(lm.rural_urban)
												      AND pwd.parameter_name = 'PWD'
												      AND lm.dist_pwd BETWEEN pwd.distance_from AND pwd.distance_to
												      AND pwd.perpetual = true

												LEFT JOIN kau.district_parameter_master mj
												       ON TRIM(mj.district) = TRIM(lm.district)
												      AND TRIM(mj.rural_urban) = TRIM(lm.rural_urban)
												      AND mj.parameter_name = 'MAJOR_CBD'
												      AND lm.d_mjcbd BETWEEN mj.distance_from AND mj.distance_to
												      AND mj.perpetual = true

												LEFT JOIN kau.district_parameter_master mn
												       ON TRIM(mn.district) = TRIM(lm.district)
												      AND TRIM(mn.rural_urban) = TRIM(lm.rural_urban)
												      AND mn.parameter_name = 'MINOR_CBD'
												      AND lm.d_ur_mncbd BETWEEN mn.distance_from AND mn.distance_to
												      AND mn.perpetual = true

												LEFT JOIN kau.district_parameter_master oil
												       ON TRIM(oil.district) = TRIM(lm.district)
												      AND TRIM(oil.rural_urban) = TRIM(lm.rural_urban)
												      AND oil.parameter_name = 'OIL_PIPELINE'
												      AND lm.oil_pipeline BETWEEN oil.distance_from AND oil.distance_to
												      AND oil.perpetual = true

												LEFT JOIN kau.district_parameter_master eco
												       ON TRIM(eco.district) = TRIM(lm.district)
												      AND TRIM(eco.rural_urban) = TRIM(lm.rural_urban)
												      AND eco.parameter_name = 'ECO_SENSITIVE'
												      AND lm.ecosensitive BETWEEN eco.distance_from AND eco.distance_to
												      AND eco.perpetual = true

												LEFT JOIN kau.mf_calculation mf
												       ON TRIM(mf.mouza) = TRIM(lm.mouza_code)
												      AND TRIM(mf.rural_urban) = TRIM(lm.rural_urban)

												LEFT JOIN kau.land_use_factor luf
												       ON TRIM(luf.land_use) = TRIM(lm.land_use)
												      AND TRIM(luf.rural_urban) = TRIM(lm.rural_urban)

												
												LEFT JOIN kau.village_land_class vlc
														ON vlc.village_code = CAST(lm.nic AS BIGINT)

												CROSS JOIN
												(
												    SELECT MIN(zonal_value) AS min_value
												    FROM kau.land_master
												    WHERE rural_urban = 'R'
												      AND land_use = 'Agricultural - III'
												      AND zonal_value > 0
												) rural_min

												CROSS JOIN
												(
												    SELECT MIN(zonal_value) AS min_value
												    FROM kau.land_master
												    WHERE rural_urban = 'U'
												      AND land_use = 'Residential - III'
												      AND zonal_value > 0
												) urban_min

												WHERE
												    lm.district IS NOT NULL
												    AND EXISTS
												    (
												        SELECT 1
												        FROM kau.district_parameter_master dpm
												        WHERE TRIM(dpm.district) = TRIM(lm.district)
												          AND dpm.perpetual = true
												    )
													;


														    					    """;


	public long generateOutputTable() {

	    long startTime = System.currentTimeMillis();

	    LOGGER.info("==================================");
	    LOGGER.info("Land Output Generation Started");
	    LOGGER.info("==================================");

	    dd.execute("TRUNCATE TABLE kau.land_master_output");

	    int count = dd.update(sql);

	    // Remove trailing ".0" from plot values
	    int updatedCount = dd.update(
	        "UPDATE kau.land_master_output " +
	        "SET plot = regexp_replace(plot, '\\.0+$', '') " +
	        "WHERE plot ~ '\\.0+$';"
	    );

	    long executionTime = (System.currentTimeMillis() - startTime) / 1000;

	    LOGGER.info("Records Inserted : {}", count);
	    LOGGER.info("Records Updated : {}", updatedCount);
	    LOGGER.info("Execution Time : {} sec", executionTime);

	    return count;
	}
}

