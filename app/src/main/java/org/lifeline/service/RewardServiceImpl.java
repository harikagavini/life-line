package org.lifeline.service;

import org.lifeline.model.Reward;
import org.lifeline.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardServiceImpl implements RewardService{

    @Autowired
    private RewardRepository rewardRepository;

    public Reward getRewardById(Long donorId) {
        return rewardRepository.findById(donorId)
                .orElseThrow(() -> new IllegalArgumentException("Reward points not found for donor"));
    }
}
