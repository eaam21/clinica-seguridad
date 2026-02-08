package com.clinica.seguridad.repository;

import com.clinica.seguridad.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> getUsuarioByNombreUsuarioAndClaveUsuario(String nombreUsuario, String claveUsuario);
}
