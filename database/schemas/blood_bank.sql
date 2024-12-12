CREATE TABLE blood_bank(
  branch_id varchar(255) NOT NULL,
  city varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  name varchar(255) NOT NULL,
  phone_num varchar(255) NOT NULL,
  state varchar(255) NOT NULL,
  street varchar(255) NOT NULL,
  zip varchar(255) NOT NULL,
  PRIMARY KEY (branch_id),
  UNIQUE KEY uk_branch_id (branch_id)
)