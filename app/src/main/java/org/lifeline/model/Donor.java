package org.lifeline.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Donor")
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long donor_id;
    @Column(name = "FirstName", nullable = false)
    private String first_name;
    @Column(name = "LastName", nullable = false)
    private String last_name;
    @Column(name = "BloodType", nullable = false)
    private String blood_type;
    @Column(name = "EmailId", nullable = false, unique = true)
    private String email;
    @Column(name = "PhoneNumber", nullable = false)
    private String phone_num;
    @Column(name = "DateOfBirth", nullable = false)
    private Date dob;
    @Column(name = "Street", nullable = false)
    private String street;
    @Column(name = "City", nullable = false)
    private String city;
    @Column(name = "State", nullable = false)
    private String state;
    @Column(name = "ZipCode", nullable = false)
    private String zip;
    @Column(name = "totalDonated", nullable = true)
    private int totalDonated;
    @Transient
    private String password;

    public Long getDonor_id() {
        return donor_id;
    }

    public void setDonor_id(Long donor_id) {
        this.donor_id = donor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotalDonated() {
        return totalDonated;
    }

    public void setTotalDonated(int totalDonated) {
        this.totalDonated = totalDonated;
    }
}
