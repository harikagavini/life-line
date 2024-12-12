CREATE TABLE donor (
  donor_id int NOT NULL,
  blood_type enum('AB_NEGATIVE','AB_POSITIVE','A_NEGATIVE','A_POSITIVE','B_NEGATIVE','B_POSITIVE','O_NEGATIVE','O_POSITIVE') NOT NULL,
  city varchar(255) NOT NULL,
  date_of_birth date NOT NULL,
  email varchar(255) NOT NULL,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  phone_number varchar(255) NOT NULL,
  state varchar(255) NOT NULL,
  street varchar(255) NOT NULL,
  zip varchar(255) NOT NULL,
  PRIMARY KEY (donor_id),
  UNIQUE KEY uk_email (email)
)
