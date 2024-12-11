package org.lifeline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Reward")
public class Reward {

    @Id
    @Column(name = "DonorId", nullable = false)
    private Long donorId;
    @Column(name = "TotalPoints", nullable = false)
    private int totalPoints;
    @Column(name = "Balance", nullable = false)
    private int balance;

    @OneToOne
    @JoinColumn(name = "DonorId", referencedColumnName = "donorId", insertable = false, updatable = false)
    private Donor donor;

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

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }
}
