package org.lifeline.controllers;

import org.lifeline.model.Donation;
import org.lifeline.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lifeline/donation")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping
    public ResponseEntity<Donation> createDonation(@RequestBody Donation donation) {
        Donation createdDonation = donationService.createDonation(donation);
        return new ResponseEntity<>(createdDonation, HttpStatus.CREATED);
    }
}
