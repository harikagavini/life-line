CREATE TABLE reward (
  donor_id int NOT NULL,
  balance int NOT NULL,
  total_points int NOT NULL,
  PRIMARY KEY (donor_id),
  FOREIGN KEY (donor_id) REFERENCES donor (donor_id)
)
