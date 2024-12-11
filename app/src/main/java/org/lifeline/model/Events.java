package org.lifeline.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Events")
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long eventId;

    @Column(name = "EventName", nullable = false)
    private String name;
    @Column(name = "EventDate", nullable = false)
    private Date eventDate;
    @Column(name = "BranchId", nullable = false)
    private String branchId;
    @Column(name = "Street", nullable = false)
    private String street;
    @Column(name = "City", nullable = false)
    private String city;
    @Column(name = "State", nullable = false)
    private String state;
    @Column(name = "Zip", nullable = false)
    private String zip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
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

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
