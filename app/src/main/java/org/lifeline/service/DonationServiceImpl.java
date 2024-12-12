package org.lifeline.service;

import jakarta.transaction.Transactional;
import org.lifeline.model.Donation;
import org.lifeline.model.Donor;
import org.lifeline.model.Reward;
import org.lifeline.repository.DonationRepository;
import org.lifeline.repository.DonorRepository;
import org.lifeline.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DonationServiceImpl implements DonationService{

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Transactional
    public Donation createDonation(Donation donation) {
        if(donation.getDonorId() == null) {
            throw new IllegalArgumentException("Donor Id cannot be null");
        }
        Optional<Donor> donor = donorRepository.findById(donation.getDonorId());
        if(donor.isPresent()) {
            if(!Objects.equals(donor.get().getBloodType().toString(), donation.getBloodType().toString())) {
                throw new IllegalArgumentException("blood type is not matching");
            }
            return donationRepository.save(donation);
        } else {
            throw new IllegalArgumentException("Donor is not present");
        }
    }
}

