CREATE TABLE storage(
  branch_id varchar(255) NOT NULL,
  blood_type enum('AB-','AB+','A-','A+','B-','B+','O-','O+') NOT NULL,
  quantity int DEFAULT NULL,
  PRIMARY KEY (branch_id),
  FOREIGN KEY (branch_id) REFERENCES blood_bank (branch_id)
)