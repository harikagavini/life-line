package org.lifeline.service;

import jakarta.transaction.Transactional;
import org.lifeline.model.Donation;
import org.lifeline.model.Donor;
import org.lifeline.model.Reward;
import org.lifeline.repository.DonationRepository;
import org.lifeline.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService{

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private RewardRepository rewardRepository;

    @Transactional
    public Donation createDonation(Donation donation) {

//        int rewardPoints = donation.getQuantity();
//        Reward reward = rewardRepository.findById(donation.getReward().getDonorId())
//                .orElseThrow(() -> new IllegalArgumentException("Donor not found"));
//
//        reward.setTotalPoints(reward.getTotalPoints() + rewardPoints);
//        reward.setBalance(reward.getBalance() + rewardPoints);
//
//        rewardRepository.save(reward);

        return donationRepository.save(donation);
    }
}

