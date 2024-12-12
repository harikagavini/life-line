CREATE TABLE donation (
  donation_id int NOT NULL,
  blood_type enum('AB_NEGATIVE','AB_POSITIVE','A_NEGATIVE','A_POSITIVE','B_NEGATIVE','B_POSITIVE','O_NEGATIVE','O_POSITIVE') NOT NULL,
  donation_date date NOT NULL,
  event_id int NOT NULL,
  quantity int NOT NULL,
  donor_id int DEFAULT NULL,
  branch_id varchar(255) NOT NULL,
  PRIMARY KEY (donation_id),
  FOREIGN KEY (donor_id) REFERENCES donor (donor_id),
  FOREIGN KEY (branch_id) REFERENCES blood_bank (branch_id),
  FOREIGN KEY (event_id) REFERENCES events (event_id)
)
