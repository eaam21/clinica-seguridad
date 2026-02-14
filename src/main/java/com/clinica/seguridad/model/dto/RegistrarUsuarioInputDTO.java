package com.clinica.seguridad.model.dto;

public record RegistrarUsuarioInputDTO(
        String nombreUsuario,
        String claveUsuario,
        String nombres,
        String apellidoPaterno,
        String apellidoMaterno,
        String dni,
        String correo
) {
}
