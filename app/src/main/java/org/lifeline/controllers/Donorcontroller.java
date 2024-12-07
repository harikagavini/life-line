package org.lifeline.controllers;


import org.lifeline.model.Donor;
import org.lifeline.repository.DonorRepository;
import org.lifeline.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lifeline")
public class Donorcontroller {

    @Autowired
    private DonorService donorService;

    @Autowired
    private DonorRepository donorRepo;

    @PostMapping("/register")
    public String registerDonor(@RequestBody Donor donor){
        donorService.saveDonor(donor);
        return "Registration Successful";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password) {
        if (donorService.validateLogin(email, password)) {
            return "Login success";
        }Donor donor = donorRepo.findByEmail(email);
        if (donor == null) {
            return "Email doesn't exist";
        } else {
            return "Login failed";
        }
    }
}
