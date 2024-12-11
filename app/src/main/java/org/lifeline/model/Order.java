package org.lifeline.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "OrderId")
    private Long orderId;

    @Column(name = "HospId", nullable = false)
    private String hospId;

    @Column(name = "BranchId", nullable = false)
    private String branchId;

    @Column(name = "BloodType", nullable = false)
    private String bloodType;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "Status", nullable = false)
    private String status;

    @Column(name = "OrderCreated", nullable = false)
    private Date orderCreated;

    @Column(name = "OrderCompleted", nullable = true)
    private Date orderCompleted;

    public String getHospId() {
        return hospId;
    }

    public void setHospId(String hospId) {
        this.hospId = hospId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
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

    public Date getOrderCreated() {
        return orderCreated;
    }

    public void setOrderCreated(Date orderCreated) {
        this.orderCreated = orderCreated;
    }

    public Date getOrderCompleted() {
        return orderCompleted;
    }

    public void setOrderCompleted(Date orderCompleted) {
        this.orderCompleted = orderCompleted;
    }
}
