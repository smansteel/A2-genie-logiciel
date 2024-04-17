package fr.genepisep.icompetences.services;

import fr.genepisep.icompetences.security.JWTUtils;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Service
public class JwtService {
    @Value("${jwt-secret}")
    private String secret;
    private SecretKey jwtSigningKey;

    @PostConstruct
    private void postConstruct() {
        jwtSigningKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String createToken(String isepId) {
        return JWTUtils.generateToken(jwtSigningKey, isepId);
    }

    public String getIsepIdFromToken(String token) {
        return JWTUtils.extractUsername(jwtSigningKey, token);
    }

}
