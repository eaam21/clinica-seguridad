package com.clinica.seguridad.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tb_usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="usuario")
    private String nombreUsuario;

    @Column(name="clave")
    private String claveUsuario;

    private String nombres;

    @Column(name="apellido_paterno")
    private String apellidoPaterno;

    @Column(name="apellido_materno")
    private String apellidoMaterno;

    private String dni;
    private String correo;
}
