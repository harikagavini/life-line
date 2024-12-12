package org.lifeline.service;

import org.lifeline.model.AuthRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    public AuthRequest validateLogin(AuthRequest authreq);
    public String generateToken(AuthRequest authreq);
}
