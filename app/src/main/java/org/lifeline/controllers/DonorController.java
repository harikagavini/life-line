package org.lifeline.controllers;


import org.lifeline.model.AuthRequest;
import org.lifeline.model.Donor;
import org.lifeline.repository.DonorRepository;
import org.lifeline.response.RegistrationSuccess;
import org.lifeline.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lifeline")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @Autowired
    private DonorRepository donorRepo;

    @PostMapping("/register")
    public RegistrationSuccess registerDonor(@RequestBody Donor donor){
        donorService.saveDonor(donor);
        RegistrationSuccess registrationSuccess = new RegistrationSuccess();
        registrationSuccess.setMessage("Registration success");
        registrationSuccess.setSuccess(true);
        return registrationSuccess;
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody AuthRequest authReq) {
        if (donorService.validateLogin(authReq)) {
            return "Login success";
        }
        Donor donor = donorRepo.findByEmail(authReq.getEmail());
        if (donor == null) {
            return "Email doesn't exist";
        } else {
            return "Login failed";
        }
    }

    @GetMapping("/home")
    public String showHomePage(){
        return "home";
    }
}
