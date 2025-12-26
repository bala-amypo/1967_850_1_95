package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;

public class JwtTokenProvider {

    private final byte[] secret;
    private final long validityMs;

    public JwtTokenProvider(String secret, long validityMs) {
        this.secret = secret.getBytes();
        this.validityMs = validityMs;
    }

    public String generateToken(Authentication auth, Long id, String email, String role) {
        return Jwts.builder()
                .setSubject(String.valueOf(id))
                .claim("email", email)
                .claim("role", role)
                .signWith(Keys.hmacShaKeyFor(secret), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUserIdFromToken(String token) {
        return Long.valueOf(
                Jwts.parserBuilder()
                        .setSigningKey(secret)
                        .build()
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject());
    }

    public String getEmailFromToken(String token) {
        return (String) Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("email");
    }

    public String getRoleFromToken(String token) {
        return (String) Jwts.parserBuilder()
                .setSigningKey(secret)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role");
    }
}
