package com.manofacil.dto;

import com.manofacil.entity.Direccion;
import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String nombre;
    private String correo;
    private Direccion direccion;
}
