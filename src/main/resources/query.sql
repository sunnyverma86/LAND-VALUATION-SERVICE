
INSERT INTO areap2landvaluation.role_master (role_code, active, created_by, created_dtm, level, role_name)
VALUES
('10001', TRUE, 'AssamGovt', CURRENT_TIMESTAMP, 4, 'Admin'),
('10002', TRUE, 'AssamGovt', CURRENT_TIMESTAMP, 3, 'SeniorManager'),
('10003', TRUE, 'AssamGovt', CURRENT_TIMESTAMP, 2, 'Manager'),
('10004', TRUE, 'AssamGovt', CURRENT_TIMESTAMP, 1, 'JuniorManager'),
('10005', TRUE, 'AssamGovt', CURRENT_TIMESTAMP, 0, 'NormalUser');




CREATE TABLE areap2landvaluation.instrument_master (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    male_duty INTEGER,
    female_duty INTEGER,
    joint_duty INTEGER
);

CREATE TABLE areap2landvaluation.user_selection (
    id BIGSERIAL PRIMARY KEY,
    instrument_id BIGINT REFERENCES areap2landvaluation.instrument_master(id),
    selected_option VARCHAR(20) NOT NULL,
    duty_value INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO instrument_master (name, male_duty, female_duty, joint_duty) VALUES
('Acknowledgement', 2, 4, 5),
('Administrative Bond', 12, 14, 15),
('Adoption Deed', 22, 24, 25),
('Affidavit', 32, 34, 35),
('Agreement for conveyance', 42, 44, 45),
('Development Agreement', 52, 53, 55),
('Other Agreement', 62, 64, 65);



-- before luf working query
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
			    district_minimum,
			    mf_calculated
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

			    CASE
			        WHEN lm.rural_urban = 'R'
			            THEN rural_min.min_value
			        WHEN lm.rural_urban = 'U'
			            THEN urban_min.min_value
			    END AS district_minimum,

			    mf."current" AS mf_calculated

			FROM kau.land_master lm

			LEFT JOIN kau.mf_calculation mf
			       ON mf.mouza = lm.mouza
			      AND mf.rural_urban = lm.rural_urban

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
			""";
--before VF working code
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
			    district_minimum,
			    mf_calculated,
			    luf
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

			    CASE
			        WHEN lm.rural_urban = 'R'
			            THEN rural_min.min_value
			        WHEN lm.rural_urban = 'U'
			            THEN urban_min.min_value
			    END AS district_minimum,

			    mf.current AS mf_calculated,

			    luf.luf AS luf

			FROM kau.land_master lm

			LEFT JOIN kau.mf_calculation mf
			       ON mf.mouza = lm.mouza
			      AND mf.rural_urban = lm.rural_urban

			LEFT JOIN kau.land_use_factor luf
			       ON luf.land_use = lm.land_use
			      AND luf.rural_urban = lm.rural_urban

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
			""";

