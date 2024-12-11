package org.lifeline.jwt;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtTokenValidator jwtTokenValidator;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
//        String token = request.getHeader("Authorization");
//
//        if (token != null && token.startsWith("Bearer ")) {
//            try {
//                jwtTokenValidator.validateToken(token.substring(7));
//                return true;
//            } catch (JwtException e) {
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT token");
//                return false;
//            }
//        } else {
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid JWT token");
//            return false;
//        }
    }
}
