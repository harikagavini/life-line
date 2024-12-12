package org.lifeline.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Donation")
public class Donation {


    @Id
    private Long donationId;
    private Long eventId;
    private int quantity;
    private String bloodType;
    private Date donationDate;

    @ManyToOne
    @JoinColumn(name = "donorId")
    private Reward reward;

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public Date getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(Date donationDate) {
        this.donationDate = donationDate;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }

    public Long getDonationId() {
        return donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }
}
