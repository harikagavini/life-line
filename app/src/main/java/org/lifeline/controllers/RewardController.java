package org.lifeline.controllers;

import org.lifeline.model.Reward;
import org.lifeline.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lifeline")
public class RewardController {

    @Autowired
    private RewardService rewardService;

    @GetMapping("/reward")
    public ResponseEntity<List<Reward>> getAllRewards() {
        List<Reward> reward = rewardService.getAllRewards();
        return new ResponseEntity<>(reward, HttpStatus.OK);
    }

    @GetMapping("/reward/{donorId}")
    public ResponseEntity<Reward> getRewardById(@PathVariable Long donorId) {
        Reward reward = rewardService.getRewardById(donorId);
        return new ResponseEntity<>(reward, HttpStatus.OK);
    }
}
