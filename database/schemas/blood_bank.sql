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