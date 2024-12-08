package org.lifeline.service;

import org.lifeline.model.Donation;

import java.util.List;

public interface DonationService {
    public Donation createDonation(Donation donation);
    public Donation updateDonation(Long id, Donation updatedDonation);
    public void deleteDonation(Long id);
    public List<Donation> getAllDonations();
}
