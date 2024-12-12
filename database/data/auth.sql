INSERT INTO auth (email, password, registration_type, branch_id, hospital_id, donor_id)
SELECT email, 'password123', 'BLOOD_BANK', branch_id, NULL, NULL FROM blood_bank
UNION ALL
SELECT email, 'password123', 'HOSPITAL', NULL, hospital_id, NULL FROM hospital_location
UNION ALL
SELECT email, 'donorpass', 'DONOR', NULL, NULL, donor_id FROM donor;
