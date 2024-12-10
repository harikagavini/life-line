package org.lifeline.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import org.lifeline.model.AuthRequest;
import org.lifeline.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

@Component
public class JwtTokenValidator {

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private AuthRepository authRepository;

    public AuthRequest validateToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            String userEmail = claimsJws.getBody().getSubject();
            return authRepository.findByEmail(userEmail);
        } catch (JwtException e) {
            throw new RuntimeException("Invalid JWT token", e);
        }
    }
}
