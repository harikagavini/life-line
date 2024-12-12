CREATE TABLE hospital_location (
  hospital_id varchar(255) NOT NULL,
  city varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  phone_num varchar(255) NOT NULL,
  state varchar(255) NOT NULL,
  street varchar(255) NOT NULL,
  zip_code varchar(255) NOT NULL,
  PRIMARY KEY (hospital_id),
  UNIQUE KEY uk_hospital_id (hospital_id)
)
