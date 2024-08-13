package com.jardefelicio.api_orders.shared.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jardefelicio.api_orders.modules.auth.dtos.AuthResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class TokenService {
    @Value("${security.token.secret}")
    private String secretKey;

    public AuthResponseDTO generateToken(String id, List<String> roles) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.secretKey);

            Instant expiresIn = this.generateExpirationDate();

            String token = JWT.create()
                    .withIssuer("api-orders")
                    .withSubject(id)
                    .withClaim("roles", roles)
                    .withExpiresAt(expiresIn)
                    .sign(algorithm);


            return new AuthResponseDTO(token, expiresIn.toEpochMilli(), roles);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while authenticating");
        }
    }

    public DecodedJWT validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.secretKey);

            return JWT.require(algorithm)
                    .withIssuer("api-orders")
                    .build()
                    .verify(token);
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return null;
        }


    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
