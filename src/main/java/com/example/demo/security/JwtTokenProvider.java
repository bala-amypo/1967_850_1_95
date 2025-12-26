package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import java.util.Date;

public class JwtTokenProvider {
    private final byte[] key;
    private final long expiry;

    public JwtTokenProvider(String secret, long expiry) {
        this.key = secret.getBytes();
        this.expiry = expiry;
    }

    public String generateToken(Authentication auth,
                                Long id, String email, String role) {
        return Jwts.builder()
                .setSubject(String.valueOf(id))
                .claim("email", email)
                .claim("role", role)
                .setExpiration(new Date(System.currentTimeMillis() + expiry))
                .signWith(Keys.hmacShaKeyFor(key), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUserIdFromToken(String token) {
        return Long.valueOf(Jwts.parserBuilder()
                .setSigningKey(key).build()
                .parseClaimsJws(token).getBody().getSubject());
    }

    public String getEmailFromToken(String token) {
        return (String) Jwts.parserBuilder()
                .setSigningKey(key).build()
                .parseClaimsJws(token).getBody().get("email");
    }

    public String getRoleFromToken(String token) {
        return (String) Jwts.parserBuilder()
                .setSigningKey(key).build()
                .parseClaimsJws(token).getBody().get("role");
    }
}
