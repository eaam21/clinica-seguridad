package com.clinica.seguridad.service;

import com.clinica.seguridad.model.Usuario;
import com.clinica.seguridad.model.dto.LoginInputDTO;

import java.util.Map;
import java.util.Optional;

public interface UsuarioService {
    Usuario createUsuario(Usuario usuario);
    Map<String, String> login(LoginInputDTO inputDTO);
}
