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