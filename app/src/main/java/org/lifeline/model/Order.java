package org.lifeline.model;

import jakarta.persistence.*;
import org.lifeline.enums.BloodType;
import org.lifeline.enums.StatusType;

import java.util.Date;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String hospitalId;
    private String branchId;

    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    private int quantity;

    @Enumerated(EnumType.STRING)
    private StatusType status;

    private Date orderCreated;
    private Date orderCompleted;

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
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

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
