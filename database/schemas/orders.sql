CREATE TABLE orders (
  order_id int NOT NULL AUTO_INCREMENT,
  blood_type enum('AB-','AB+','A-','A+','B-','B+','O-','O+') NOT NULL,
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