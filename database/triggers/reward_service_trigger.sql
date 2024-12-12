CREATE TRIGGER check_and_update_rewards_before_service_visit
BEFORE INSERT ON SERVICE_VISIT
FOR EACH ROW
BEGIN
    DECLARE current_balance INT;

    -- Retrieve the current balance for the donor
    SELECT balance INTO current_balance
    FROM reward
    WHERE donor_id = NEW.donor_id;

    IF current_balance < NEW.points_cost THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient points in rewards to complete the service visit';
    ELSE
        -- Deduct the points cost from the balance
        UPDATE reward
        SET balance = balance - NEW.points_cost
        WHERE donor_id = NEW.donor_id;
    END IF;
END