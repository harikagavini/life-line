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
