package org.lifeline.controllers;


import org.lifeline.model.AuthRequest;
import org.lifeline.model.Donor;
import org.lifeline.repository.DonorRepository;
import org.lifeline.response.LoginResponse;
import org.lifeline.response.RegistrationResponse;
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
    public RegistrationResponse registerDonor(@RequestBody Donor donor){
        donorService.saveDonor(donor);
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setMessage("Registration success");
        registrationResponse.setSuccess(true);
        return registrationResponse;
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody AuthRequest authReq) {
        String token = donorService.validateLogin(authReq);
        if (token != null) {
            return getLoginResponse("Login Success", true, token);
        }
        Donor donor = donorRepo.findByEmail(authReq.getEmail());
        if (donor == null) {
            return getLoginResponse("Email doesn't exist", true, null);
        } else {
            return getLoginResponse("Login Failed", true, null);
        }
    }

    private LoginResponse getLoginResponse(String msg, Boolean success, String token) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage(msg);
        loginResponse.setSuccess(success);
        if(token != null) loginResponse.setToken(token);
        return loginResponse;
    }

    @GetMapping("/home")
    public String showHomePage(){
        return "home";
    }
}
