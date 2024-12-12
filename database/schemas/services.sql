CREATE TABLE SERVICES (
  service_id int NOT NULL,
  name VARCHAR(255) NOT NULL,
  hospital_id varchar(255) NOT NULL,
  points_cost INT NOT NULL,
  PRIMARY KEY (service_id),
  FOREIGN KEY (hospital_id) REFERENCES hospital_location (hospital_id)
)
