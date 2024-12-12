INSERT INTO events (branch_id, city, event_date, name, state, street, zip)
VALUES
('BB001', 'New York', CURDATE() + INTERVAL 1 DAY, 'NY Blood Drive', 'NY', '5th Avenue', '10001'),
('BB002', 'Los Angeles', CURDATE() - INTERVAL 1 DAY, 'LA Blood Drive', 'CA', 'Sunset Blvd', '90001'),
('BB003', 'Chicago', CURDATE() - INTERVAL 3 DAY, 'Chicago Blood Drive', 'IL', 'Lake Shore Drive', '60601'),
('BB004', 'Houston', CURDATE() + INTERVAL 5 DAY, 'Houston Blood Drive', 'TX', 'Main St', '77001'),
('BB005', 'Phoenix', CURDATE(), 'Phoenix Blood Drive', 'AZ', 'Camelback Rd', '85001');