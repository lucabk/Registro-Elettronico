package it.registro.scuola.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String generateToken(String username);
    boolean validateToken(String username, UserDetails userDetails);
    String extractUsername(String token);
}
