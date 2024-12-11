package org.lifeline.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Donation")
public class Donation {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long donationId;
    @Column(name = "EventId", nullable = false)
    private Long eventId;
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    @Column(name = "BloodType", nullable = false)
    private String bloodType;
    @Column(name = "DonationDate", nullable = false)
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
}
