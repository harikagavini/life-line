package org.lifeline.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // Assuming order_id is auto-generated
    @Column(name = "OrderId")
    private Long order_id;

    @Column(name = "HospId", nullable = false)
    private String hosp_id;  // Hospital ID (varchar)

    @Column(name = "BranchId", nullable = false)
    private String branch_id;  // Branch ID (varchar)

    @Column(name = "BloodType", nullable = false)
    private String blood_type;  // Blood type (varchar)

    @Column(name = "Quantity", nullable = false)
    private int quantity;  // Quantity of blood (int)

    @Column(name = "Status", nullable = false)
    private String status;  // Status of the order (string)

    @Column(name = "OrderCreated", nullable = false)
    private Date order_created;  // Timestamp when the order was created

    @Column(name = "OrderCompleted", nullable = true)
    private Date order_completed;

    public String getHosp_id() {
        return hosp_id;
    }

    public void setHosp_id(String hosp_id) {
        this.hosp_id = hosp_id;
    }

    public String getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(String branch_id) {
        this.branch_id = branch_id;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrder_created() {
        return order_created;
    }

    public void setOrder_created(Date order_created) {
        this.order_created = order_created;
    }

    public Date getOrder_completed() {
        return order_completed;
    }

    public void setOrder_completed(Date order_completed) {
        this.order_completed = order_completed;
    }
}
