package com.clinica.seguridad.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.util.Date;

@Component
public class JwtUtil {
    private final PrivateKey privateKey;

    public JwtUtil(RsaKeyProvider provider) {
        this.privateKey = provider.getPrivateKey();
    }

    public String generarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer("ms-auth")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(privateKey, SignatureAlgorithm.RS256)
                .compact();
    }
}
