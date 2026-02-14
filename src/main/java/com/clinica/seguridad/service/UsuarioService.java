package com.clinica.seguridad.service;

import com.clinica.seguridad.model.Usuario;
import com.clinica.seguridad.model.dto.LoginInputDTO;
import com.clinica.seguridad.model.dto.RegistrarUsuarioInputDTO;
import com.clinica.seguridad.model.dto.GenericOutputDTO;

import java.util.List;
import java.util.Map;

public interface UsuarioService {
    GenericOutputDTO createUsuario(RegistrarUsuarioInputDTO inputDTO);
    GenericOutputDTO login(LoginInputDTO inputDTO);
    List<Usuario> listar();
}
