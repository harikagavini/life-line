package org.lifeline.service;

import org.lifeline.model.Reward;

import java.util.List;

public interface RewardService {
    public Reward getRewardById(Long donorId);
    public List<Reward> getAllRewards();
}
