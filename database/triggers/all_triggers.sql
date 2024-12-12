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


CREATE TRIGGER update_storage_after_donation_insert
AFTER INSERT ON donation
FOR EACH ROW
BEGIN
    DECLARE existing_row_count INT;

    -- Check if a matching row exists in the storage table
    SELECT COUNT(*) INTO existing_row_count
    FROM storage
    WHERE branch_id = NEW.branch_id AND blood_type = NEW.blood_type;

    IF existing_row_count > 0 THEN
        -- Update the quantity of the respective blood type in the storage table
        UPDATE storage
        SET quantity = COALESCE(quantity, 0) + NEW.quantity
        WHERE branch_id = NEW.branch_id AND blood_type = NEW.blood_type;
    ELSE
        -- Insert a new row into the storage table
        INSERT INTO storage (branch_id, blood_type, quantity)
        VALUES (NEW.branch_id, NEW.blood_type, NEW.quantity);
    END IF;
END

CREATE TRIGGER update_storage_after_order_completed
AFTER UPDATE ON orders
FOR EACH ROW
BEGIN
    -- Check if the order status has been changed to COMPLETED
    IF NEW.status = 'COMPLETED' AND OLD.status != 'COMPLETED' THEN
        SET @current_quantity = (
            SELECT quantity
            FROM storage
            WHERE branch_id = NEW.branch_id AND blood_type = NEW.blood_type
        );

        IF @current_quantity >= NEW.quantity THEN
            -- Reduce the quantity in the storage table
            UPDATE storage
            SET quantity = quantity - NEW.quantity
            WHERE branch_id = NEW.branch_id AND blood_type = NEW.blood_type;
        ELSE
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Insufficient quantity in storage for this order';
        END IF;
    END IF;
END

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