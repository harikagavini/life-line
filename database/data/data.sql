-- Insert into blood_bank table
INSERT INTO blood_bank (branch_id, city, email, name, phone_num, state, street, zip)
VALUES
('BB001', 'New York', 'ny_bb@example.com', 'NY Blood Bank', '1234567890', 'NY', '5th Avenue', '10001'),
('BB002', 'Los Angeles', 'la_bb@example.com', 'LA Blood Bank', '0987654321', 'CA', 'Sunset Blvd', '90001'),
('BB003', 'Chicago', 'chi_bb@example.com', 'Chicago Blood Bank', '1122334455', 'IL', 'Lake Shore Drive', '60601'),
('BB004', 'Houston', 'hou_bb@example.com', 'Houston Blood Bank', '6677889900', 'TX', 'Main St', '77001'),
('BB005', 'Phoenix', 'phx_bb@example.com', 'Phoenix Blood Bank', '4433221100', 'AZ', 'Camelback Rd', '85001');

-- Insert into donor table
INSERT INTO donor (blood_type, city, dob, email, first_name, last_name, phone_number, state, street, zip)
VALUES
('A_POSITIVE', 'New York', '1985-06-15', 'john.doe@example.com', 'John', 'Doe', '1234567891', 'NY', 'Broadway', '10001'),
('O_NEGATIVE', 'Los Angeles', '1990-07-20', 'jane.smith@example.com', 'Jane', 'Smith', '9876543210', 'CA', 'Hollywood Blvd', '90001'),
('B_POSITIVE', 'Chicago', '1988-03-22', 'jack.black@example.com', 'Jack', 'Black', '5566778899', 'IL', 'Michigan Ave', '60601'),
('AB_NEGATIVE', 'Houston', '1975-11-13', 'kate.green@example.com', 'Kate', 'Green', '6677889900', 'TX', 'Elm St', '77001'),
('O_POSITIVE', 'Phoenix', '1992-09-08', 'luke.white@example.com', 'Luke', 'White', '4433221100', 'AZ', 'Camelback Rd', '85001');

-- Insert into events table
INSERT INTO events (branch_id, city, event_date, name, state, street, zip)
VALUES
('BB001', 'New York', CURDATE() + INTERVAL 1 DAY, 'NY Blood Drive', 'NY', '5th Avenue', '10001'),
('BB002', 'Los Angeles', CURDATE() - INTERVAL 1 DAY, 'LA Blood Drive', 'CA', 'Sunset Blvd', '90001'),
('BB003', 'Chicago', CURDATE() - INTERVAL 3 DAY, 'Chicago Blood Drive', 'IL', 'Lake Shore Drive', '60601'),
('BB004', 'Houston', CURDATE() + INTERVAL 5 DAY, 'Houston Blood Drive', 'TX', 'Main St', '77001'),
('BB005', 'Phoenix', CURDATE(), 'Phoenix Blood Drive', 'AZ', 'Camelback Rd', '85001');

-- Insert into donation table
INSERT INTO donation (blood_type, donation_date, event_id, quantity, donor_id, branch_id)
VALUES
('A_POSITIVE', CURDATE() + INTERVAL 1 DAY, 1, 5, 1, 'BB001'),
('O_NEGATIVE', CURDATE() - INTERVAL 1 DAY, 2, 3, 2, 'BB002'),
('B_POSITIVE', CURDATE() - INTERVAL 3 DAY, 3, 2, 3, 'BB003'),
('AB_NEGATIVE', CURDATE() + INTERVAL 5 DAY, 4, 4, 'BB004'),
('O_POSITIVE', CURDATE(), 5, 6, 5, 'BB005');

-- Insert into hospital_location table
INSERT INTO hospital_location (hospital_id, city, email, name, phone_num, state, street, zip)
VALUES
('H001', 'New York', 'ny_hospital@example.com', 'NY Hospital', '1122334455', 'NY', 'Madison Avenue', '10001'),
('H002', 'Los Angeles', 'la_hospital@example.com', 'LA Hospital', '5566778899', 'CA', 'Wilshire Blvd', '90001'),
('H003', 'Chicago', 'chi_hospital@example.com', 'Chicago Hospital', '4455667788', 'IL', 'State St', '60601'),
('H004', 'Houston', 'hou_hospital@example.com', 'Houston Hospital', '6677889900', 'TX', 'Fannin St', '77001'),
('H005', 'Phoenix', 'phx_hospital@example.com', 'Phoenix Hospital', '3344556677', 'AZ', 'Central Ave', '85001');

-- Insert into orders table
INSERT INTO orders (blood_type, branch_id, hospital_id, order_completed, order_created, quantity, status)
VALUES
('A_POSITIVE', 'BB001', 'H001', NULL, CURDATE(), 5, 'PENDING'),
('O_NEGATIVE', 'BB002', 'H002', CURDATE(), CURDATE() - INTERVAL 1 DAY, 3, 'COMPLETED'),
('B_POSITIVE', 'BB003', 'H003', CURDATE() - INTERVAL 2 DAY, CURDATE() - INTERVAL 3 DAY, 7, 'PENDING'),
('AB_NEGATIVE', 'BB004', 'H004', NULL, CURDATE() - INTERVAL 5 DAY, 4, 'PENDING'),
('O_POSITIVE', 'BB005', 'H005', CURDATE(), CURDATE() - INTERVAL 1 DAY, 6, 'COMPLETED');

-- Insert into services table
INSERT INTO services (service_id, name, hospital_id, points_cost)
VALUES
(1, 'Blood Test', 'H001', 100),
(2, 'MRI Scan', 'H002', 300),
(3, 'CT Scan', 'H003', 200),
(4, 'X-Ray', 'H004', 150),
(5, 'Ultrasound', 'H005', 250);

-- Insert into service_visit table
-- INSERT INTO service_visit (visit_id, service_id, donor_id, points_cost)
-- VALUES
-- (1, 1, 1, 100),
-- (2, 2, 2, 300),
-- (3, 3, 3, 200),
-- (4, 4, 4, 150),
-- (5, 5, 5, 250);

-- Insert into auth table
INSERT INTO auth (email, password, registration_type, branch_id, hospital_id, donor_id)
SELECT email, 'password123', 'BLOOD_BANK', branch_id, NULL, NULL FROM blood_bank
UNION ALL
SELECT email, 'password123', 'HOSPITAL', NULL, hospital_id, NULL FROM hospital_location
UNION ALL
SELECT email, 'donorpass', 'DONOR', NULL, NULL, donor_id FROM donor;
