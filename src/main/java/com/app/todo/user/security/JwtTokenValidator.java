package com.app.todo.user.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.UUID;

@Component
public class JwtTokenValidator {

    private final SecretKey key;

    public JwtTokenValidator(@Value("${jwt.secret}") String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }


    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        }
        catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    public UUID getUserId(String token) {
        String userId = Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("userId", String.class);

        return UUID.fromString(userId);
    }
}
