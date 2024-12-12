package org.lifeline.model;

import jakarta.persistence.*;
import org.lifeline.enums.BloodType;

@Entity
@Table(name = "Storage")
public class Storage {
    private String branchId;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }
}
