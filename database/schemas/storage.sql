CREATE TABLE storage(
  branch_id varchar(255) NOT NULL,
  blood_type enum('AB_NEGATIVE','AB_POSITIVE','A_NEGATIVE','A_POSITIVE','B_NEGATIVE','B_POSITIVE','O_NEGATIVE','O_POSITIVE') NOT NULL,
  quantity int DEFAULT NULL,
  PRIMARY KEY (branch_id),
  FOREIGN KEY (branch_id) REFERENCES blood_bank (branch_id)
)