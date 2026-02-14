package com.clinica.seguridad.controller;

import com.clinica.seguridad.model.Usuario;
import com.clinica.seguridad.model.dto.LoginInputDTO;
import com.clinica.seguridad.model.dto.RegistrarUsuarioInputDTO;
import com.clinica.seguridad.model.dto.GenericOutputDTO;
import com.clinica.seguridad.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/listar")
    public List<Usuario> getAllUsers() {
        return usuarioService.listar();
    }

    @PostMapping("/registrar")
    public GenericOutputDTO crearUsuario(@RequestBody RegistrarUsuarioInputDTO usuarioInputDTO) {
        return usuarioService.createUsuario(usuarioInputDTO);
    }

    @PostMapping("/login")
    public GenericOutputDTO loginUsuario(@RequestBody LoginInputDTO loginInputDTO) {
        return usuarioService.login(loginInputDTO);
    }
}
