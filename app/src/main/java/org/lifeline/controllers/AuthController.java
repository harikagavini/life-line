package org.lifeline.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.lifeline.model.AuthRequest;
import org.lifeline.response.LoginResponse;
import org.lifeline.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifeline")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody AuthRequest authReq, HttpServletResponse response) {
        AuthRequest authRequest = authService.validateLogin(authReq);

        if (authRequest != null) {
            String token = authService.generateToken(authRequest);
            return getLoginResponse(
                    "Login Success",
                    true,
                    token,
                    authRequest.getBranchId(),
                    authRequest.getHospitalId()
            );
        } else {
            return getLoginResponse("Login Failed", false, null, null, null);
        }
    }

    private LoginResponse getLoginResponse(String msg, Boolean success, String token, String branchId, String hospitalId) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage(msg);
        loginResponse.setSuccess(success);
        if(token != null) loginResponse.setToken(token);
        if(branchId != null) loginResponse.setBranchId(branchId);
        if(hospitalId != null) loginResponse.setHospitalId(hospitalId);

        return loginResponse;
    }
}
