package fr.genepisep.icompetences.security;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;
import java.util.Date;

public class JWTUtils {
    private static final long EXPIRATION_TIME = 3_600_000; // 10 days

    public static String generateToken(SecretKey jwtSigningKey, String isepId) {
        return Jwts.builder()
                .signWith(jwtSigningKey)
                .subject(isepId)
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();

    }

    public static String extractUsername(SecretKey jwtSigningKey, String token) {
        return Jwts.parser()
                .verifyWith(jwtSigningKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
