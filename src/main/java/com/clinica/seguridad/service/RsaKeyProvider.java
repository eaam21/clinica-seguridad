package com.clinica.seguridad.service;

import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Component
public class RsaKeyProvider {
    private final PrivateKey privateKey;

    public RsaKeyProvider() throws Exception {
        String key = Files.readString(Path.of("private.pem"))
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s+", "");

        byte[] decoded = Base64.getDecoder().decode(key);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
        this.privateKey = KeyFactory.getInstance("RSA").generatePrivate(spec);
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }
}
