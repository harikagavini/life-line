package org.lifeline.model;


import jakarta.persistence.*;

@Entity
@Table(name = "HospitalLocation")
public class HospitalLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospId;

    private String name;
    private String email;
    private String phoneNum;
    private String street;
    private String city;
    private String state;
    private String zip;



    public Long getHospId() {
        return hospId;
    }

    public void setHospId(Long hospId) {
        this.hospId = hospId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
}
