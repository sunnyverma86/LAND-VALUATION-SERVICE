
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

INSERT INTO areap2landvaluation.role_master (role_code, active, created_by, created_dtm, level, role_name)
VALUES
('10001', TRUE, 'AssamGovt', CURRENT_TIMESTAMP, 4, 'Admin'),
('10002', TRUE, 'AssamGovt', CURRENT_TIMESTAMP, 3, 'SeniorManager'),
('10003', TRUE, 'AssamGovt', CURRENT_TIMESTAMP, 2, 'Manager'),
('10004', TRUE, 'AssamGovt', CURRENT_TIMESTAMP, 1, 'JuniorManager'),
('10005', TRUE, 'AssamGovt', CURRENT_TIMESTAMP, 0, 'NormalUser');



