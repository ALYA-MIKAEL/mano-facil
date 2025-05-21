package com.manofacil.dto;

import lombok.Data;

@Data
public class UsuarioRequestDTO {
    private String nombre;
    private String correo;
    private String contraseña;
    private String calle;
    private String ciudad;
    private String distrito;
    private String referencia;
}

