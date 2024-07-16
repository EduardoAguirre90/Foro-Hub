package com.foro.forohub.infra.secutiry;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.foro.forohub.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private  String apiSecret;

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("foro_db")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            // Invalid Signing configuration / Couldn't convert Claims.
            throw new RuntimeException();
        }
    }

    public String getSubject(String token) {
        if (token == null || token.isEmpty()){
            throw new RuntimeException("El toquen no puede ser nulo o vacio");
        }
        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    // specify any specific claim validations
                    .withIssuer("foro_db")
                    // reusable verifier instance
                    .build()
                    .verify(token);
            verifier.getSubject();

            // Verifica que el verifier y su subject no sean nulos
            if (verifier != null && verifier.getSubject() != null) {
                return verifier.getSubject();
            } else {
                throw new RuntimeException("Token no válido o subject no encontrado");
            }
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Error al verificar el token", exception);
        }

    }

    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }
}
