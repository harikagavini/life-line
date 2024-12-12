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