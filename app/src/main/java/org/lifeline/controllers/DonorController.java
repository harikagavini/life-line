package org.lifeline.controllers;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.lifeline.model.AuthRequest;
import org.lifeline.model.Donor;
import org.lifeline.repository.DonorRepository;
import org.lifeline.response.LoginResponse;
import org.lifeline.response.RegistrationResponse;
import org.lifeline.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public LoginResponse loginUser(@RequestBody AuthRequest authReq, HttpServletResponse response) {
        String token = donorService.validateLogin(authReq);
        if (token != null) {
            // Set the cookie on the server-side
            Cookie cookie = new Cookie("token", token);
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            response.addCookie(cookie);

            // Return a redirect response
            return getLoginResponse("Login Success", true, token);
        } else {
            // Return an error response
            return getLoginResponse("Login Failed", false, null);
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
