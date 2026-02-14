package com.clinica.seguridad.model.dto;

public record GenericOutputDTO(
        Boolean success,
        String mensaje,
        Object data
) {
}
