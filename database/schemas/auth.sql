CREATE TABLE auth (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  registration_type enum('BLOOD_BANK','DONOR','HOSPITAL') NOT NULL,
  branch_id varchar(255) NULL,
  hospital_id varchar(255) NULL,
  donor_id varchar(255) NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uk_email (email),
  CONSTRAINT chk_branch_or_hospital CHECK (
    (branch_id IS NULL AND hospital_id IS NOT NULL AND donor_id IS NULL) OR
    (branch_id IS NOT NULL AND hospital_id IS NULL AND donor_id IS NULL) OR
    (branch_id IS NULL AND hospital_id IS NULL AND donor_id IS NOT NULL)
  )
)