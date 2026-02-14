package com.clinica.seguridad.util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

import javax.crypto.SecretKey;
import java.security.PrivateKey;
import java.util.Date;

@RequiredArgsConstructor
public class JwtUtil {

    public static String generateToken(String username) throws Exception {
        PrivateKey key = KeyUtil.loadPrivateKey("private.pem");

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key, Jwts.SIG.RS256)
                .compact();
    }
}
