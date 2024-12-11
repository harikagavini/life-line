package org.lifeline.service;

import org.lifeline.jwt.JwtTokenGenerator;
import org.lifeline.model.AuthRequest;
import org.lifeline.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private JwtTokenGenerator jwtTokenGenerator;

    public String validateLogin(AuthRequest authReq) {
        AuthRequest authRequest = authRepository.findByEmail(authReq.getEmail());
        if (authRequest != null &&
            authRequest.getPassword().equals(authReq.getPassword()) &&
            authRequest.getRegistrationType().equals(authReq.getRegistrationType())
        ) {
            return jwtTokenGenerator.generateToken(authReq);
        }
        return null;
    }
}
