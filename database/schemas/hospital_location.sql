CREATE TABLE hospital_location (
  hospital_id varchar(255) NOT NULL,
  city varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  phone_num varchar(255) NOT NULL,
  state varchar(255) NULL,
  street varchar(255) NULL,
  zip varchar(255) NULL,
  PRIMARY KEY (hospital_id)
)