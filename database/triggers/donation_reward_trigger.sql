CREATE TRIGGER update_reward_trigger
AFTER INSERT ON donation
FOR EACH ROW
BEGIN
    DECLARE reward_row_count INT;
    SELECT COUNT(*) INTO reward_row_count
    FROM reward
    WHERE donor_id = NEW.donor_id;
    IF reward_row_count > 0 THEN

        UPDATE reward
        SET balance = balance + NEW.quantity,
            total_points = total_points + NEW.quantity
        WHERE donor_id = NEW.donor_id;
    ELSE

        INSERT INTO reward (donor_id, balance, total_points)
        VALUES (NEW.donor_id, NEW.quantity, NEW.quantity);
    END IF;
END
