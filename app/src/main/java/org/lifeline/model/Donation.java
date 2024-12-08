package org.lifeline.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Date;

@Entity
@Table(name = "Donation")
public class Donation {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long donation_id;

    private Long event_id;
    private String bb_id;
    private String hosp_id;
    private int quantity;
    private String blood_type;
    private Date donation_date;

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private Reward reward;


    public Long getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Long event_id) {
        this.event_id = event_id;
    }

    public String getBb_id() {
        return bb_id;
    }

    public void setBb_id(String bb_id) {
        this.bb_id = bb_id;
    }

    public String getHosp_id() {
        return hosp_id;
    }

    public void setHosp_id(String hosp_id) {
        this.hosp_id = hosp_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public Date getDonation_date() {
        return donation_date;
    }

    public void setDonation_date(Date donation_date) {
        this.donation_date = donation_date;
    }

    public Reward getReward() {
        return reward;
    }

    public void setReward(Reward reward) {
        this.reward = reward;
    }
}
