CREATE TABLE SERVICE_VISIT (
visit_id int NOT NULL,
service_id int NOT NULL,
donor_id int NOT NULL,
points_cost int NOT NULL,
PRIMARY KEY (visit_id),
FOREIGN KEY (service_id) REFERENCES services (service_id),
FOREIGN KEY (donor_id) REFERENCES donor (donor_id)
)