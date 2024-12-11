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

        int rewardPoints = donation.getQuantity();
        Reward reward = rewardRepository.findById(donation.getReward().getDonorId())
                .orElseThrow(() -> new IllegalArgumentException("Donor not found"));

        reward.setTotalPoints(reward.getTotalPoints() + rewardPoints);
        reward.setBalance(reward.getBalance() + rewardPoints);

        rewardRepository.save(reward);

        return donationRepository.save(donation);
    }

    @Override
    public List<Donation> getAllDonations() {
        return donationRepository.findAll();  // This uses the built-in findAll() method of JpaRepository
    }

    @Override
    public Donation updateDonation(Long id, Donation updatedDonation) {
        Donation existingDonation = donationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Donation not found"));

        int oldQuantity = existingDonation.getQuantity();
        int newQuantity = updatedDonation.getQuantity();
        existingDonation.setEventId(updatedDonation.getEventId());
        existingDonation.setQuantity(newQuantity);
        existingDonation.setBloodType(updatedDonation.getBloodType());
        existingDonation.setDonationDate(updatedDonation.getDonationDate());

        if (oldQuantity != newQuantity) {
            Donor donor = existingDonation.getReward().getDonor();
            Reward donorReward = rewardRepository.findById(donor.getDonorId())
                    .orElseThrow(() -> new IllegalArgumentException("Reward not found for donor"));

            int pointsPerUnit = 1;
            int pointsDifference = (newQuantity - oldQuantity) * pointsPerUnit;

            donorReward.setTotalPoints(donorReward.getTotalPoints() + pointsDifference);
            donorReward.setBalance(donorReward.getBalance() + pointsDifference);

            rewardRepository.save(donorReward);
        }
        return donationRepository.save(existingDonation);
    }


    @Override
    public void deleteDonation(Long id) {
        Donation donation = donationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Donation not found"));

        donationRepository.delete(donation);
    }
}

