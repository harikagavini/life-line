CREATE TABLE orders (
  order_id int NOT NULL,
  blood_type enum('AB_NEGATIVE','AB_POSITIVE','A_NEGATIVE','A_POSITIVE','B_NEGATIVE','B_POSITIVE','O_NEGATIVE','O_POSITIVE') NOT NULL,
  branch_id varchar(255) NOT NULL,
  hospital_id varchar(255) NOT NULL,
  order_completed timestamp DEFAULT NULL,
  order_created timestamp NOT NULL,
  quantity int NOT NULL,
  status enum('CANCELLED','COMPLETED','PENDING') NOT NULL,
  PRIMARY KEY (order_id),
  FOREIGN KEY (branch_id) REFERENCES blood_bank (branch_id),
  FOREIGN KEY (hospital_id) REFERENCES hospital_location (hospital_id)
)