package org.lifeline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Reward")
public class Reward {

    @Id
    @Column(name = "donor_id")
    private Long donor_id;

    private int tot_points;
    private int balance;

    @OneToOne
    @JoinColumn(name = "donor_id", referencedColumnName = "donor_id", insertable = false, updatable = false)
    private Donor donor;

    public Long getDonor_id() {
        return donor_id;
    }

    public void setDonor_id(Long donor_id) {
        this.donor_id = donor_id;
    }

    public int getTot_points() {
        return tot_points;
    }

    public void setTot_points(int tot_points) {
        this.tot_points = tot_points;
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
