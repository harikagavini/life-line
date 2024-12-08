package org.lifeline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "BloodBank")
public class BloodBank {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long branch_id;

    private String bb_id;
    private String name;
    private String email;
    private String phone_num;
    private String street;
    private String city;
    private String state;
    private String zip;


    public Long getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(Long branch_id) {
        this.branch_id = branch_id;
    }

    public String getBb_id() {
        return bb_id;
    }

    public void setBb_id(String bb_id) {
        this.bb_id = bb_id;
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
}
