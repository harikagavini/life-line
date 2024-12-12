INSERT INTO donation (blood_type, donation_date, event_id, quantity, donor_id, branch_id)
VALUES
('A_POSITIVE', CURDATE() + INTERVAL 1 DAY, 1, 5, 1, 'BB001'),
('O_NEGATIVE', CURDATE() - INTERVAL 1 DAY, 2, 3, 2, 'BB002'),
('B_POSITIVE', CURDATE() - INTERVAL 3 DAY, 3, 2, 3, 'BB003'),
('AB_NEGATIVE', CURDATE() + INTERVAL 5 DAY, 4, 4, 4, 'BB004'),
('O_POSITIVE', CURDATE(), 5, 6, 5, 'BB005');
