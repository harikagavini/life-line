CREATE TABLE auth (
  id int NOT NULL AUTO_INCREMENT,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  registration_type enum('BLOOD_BANK','DONOR','HOSPITAL') NOT NULL,
  branch_id varchar(255) NULL,
  hospital_id varchar(255) NULL,
  donor_id varchar(255) NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uk_email (email),
  CONSTRAINT chk_branch_or_hospital CHECK (
    (branch_id IS NULL AND hospital_id IS NOT NULL AND donor_id IS NULL) OR
    (branch_id IS NOT NULL AND hospital_id IS NULL AND donor_id IS NULL) OR
    (branch_id IS NULL AND hospital_id IS NULL AND donor_id IS NOT NULL)
  )
)


CREATE TABLE blood_bank(
  branch_id varchar(255) NOT NULL,
  city varchar(255) NULL,
  email varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  phone_num varchar(255) NOT NULL,
  state varchar(255) NULL,
  street varchar(255) NULL,
  zip varchar(255) NULL,
  PRIMARY KEY (branch_id),
  UNIQUE KEY uk_bb_email (email)
)

CREATE TABLE donation (
  donation_id int NOT NULL AUTO_INCREMENT,
  blood_type enum('AB_NEGATIVE','AB_POSITIVE','A_NEGATIVE','A_POSITIVE','B_NEGATIVE','B_POSITIVE','O_NEGATIVE','O_POSITIVE') NOT NULL,
  donation_date date NOT NULL,
  event_id int NOT NULL,
  quantity int NOT NULL,
  donor_id int NOT NULL,
  branch_id varchar(255) NOT NULL,
  PRIMARY KEY (donation_id),
  FOREIGN KEY (donor_id) REFERENCES donor (donor_id),
  FOREIGN KEY (branch_id) REFERENCES blood_bank (branch_id),
  FOREIGN KEY (event_id) REFERENCES events (event_id)
)


CREATE TABLE donor (
  donor_id int NOT NULL AUTO_INCREMENT,
  blood_type enum('AB_NEGATIVE','AB_POSITIVE','A_NEGATIVE','A_POSITIVE','B_NEGATIVE','B_POSITIVE','O_NEGATIVE','O_POSITIVE') NOT NULL,
  city varchar(255) NULL,
  dob date NOT NULL,
  email varchar(255) NOT NULL,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  phone_number varchar(255) NOT NULL,
  state varchar(255) NULL,
  street varchar(255) NULL,
  zip varchar(255) NULL,
  PRIMARY KEY (donor_id),
  UNIQUE KEY uk_donor_email (email)
)


CREATE TABLE events (
  event_id int NOT NULL AUTO_INCREMENT,
  branch_id varchar(255) NOT NULL,
  city varchar(255) NOT NULL,
  event_date date NOT NULL,
  name varchar(255) NOT NULL,
  state varchar(255) NOT NULL,
  street varchar(255) NOT NULL,
  zip varchar(255) NOT NULL,
  PRIMARY KEY (event_id),
  FOREIGN KEY (branch_id) REFERENCES blood_bank (branch_id)
)


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

CREATE TABLE reward (
  donor_id int NOT NULL,
  balance int NOT NULL,
  total_points int NOT NULL,
  PRIMARY KEY (donor_id),
  FOREIGN KEY (donor_id) REFERENCES donor (donor_id)
)


CREATE TABLE service_visit (
    visit_id int NOT NULL,
    service_id int NOT NULL,
    donor_id int NOT NULL,
    points_cost int NOT NULL,
    PRIMARY KEY (visit_id),
    FOREIGN KEY (service_id) REFERENCES services (service_id),
    FOREIGN KEY (donor_id) REFERENCES donor (donor_id)
)

CREATE TABLE services (
  service_id int NOT NULL,
  name VARCHAR(255) NOT NULL,
  hospital_id varchar(255) NOT NULL,
  points_cost INT NOT NULL,
  PRIMARY KEY (service_id),
  FOREIGN KEY (hospital_id) REFERENCES hospital_location (hospital_id)
)


CREATE TABLE storage(
  id int NOT NULL AUTO_INCREMENT,
  branch_id varchar(255) NOT NULL,
  blood_type enum('AB_NEGATIVE','AB_POSITIVE','A_NEGATIVE','A_POSITIVE','B_NEGATIVE','B_POSITIVE','O_NEGATIVE','O_POSITIVE') NOT NULL,
  quantity int DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (branch_id) REFERENCES blood_bank (branch_id)
)