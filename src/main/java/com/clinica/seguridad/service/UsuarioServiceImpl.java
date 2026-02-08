package com.clinica.seguridad.service;

import com.clinica.seguridad.model.Usuario;
import com.clinica.seguridad.model.dto.LoginInputDTO;
import com.clinica.seguridad.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements  UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public Map<String, String> login(LoginInputDTO inputDTO) {
        Optional<Usuario> usuario = usuarioRepository.getUsuarioByNombreUsuarioAndClaveUsuario(inputDTO.nombreUsuario(), inputDTO.claveUsuario());
        if (usuario.isPresent()) {
            return Map.of("token", jwtUtil.generarToken(inputDTO.nombreUsuario()));
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
}
