package org.lifeline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Reward")
public class Reward {

    @Id
    private Long donorId;
    private int totalPoints;
    private int balance;

    public Long getDonorId() {
        return donorId;
    }
    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }
    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
