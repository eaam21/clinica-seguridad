package com.clinica.seguridad.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptUtil {
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String encriptar(String plainText) {
        return passwordEncoder.encode(plainText);
    }

    public Boolean validarPassword(String rawPassword,String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
