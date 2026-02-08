package com.clinica.seguridad.controller;

import com.clinica.seguridad.model.dto.LoginInputDTO;
import com.clinica.seguridad.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginInputDTO inputDTO) {
        return usuarioService.login(inputDTO);
    }
}
