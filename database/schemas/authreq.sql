CREATE TABLE auth (
  id int NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  registration_type enum('BLOOD_BANK','DONOR','HOSPITAL') NOT NULL,
  PRIMARY KEY (email),
  UNIQUE KEY uk_email (email)
)