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
        String token = authService.validateLogin(authReq);
        if (token != null) {
            return getLoginResponse("Login Success", true, token);
        } else {
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
}
