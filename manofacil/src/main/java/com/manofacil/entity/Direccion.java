package com.manofacil.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private String calle;
    private String ciudad;
    private String codigoPostal;
    private String distrito;
    private String referencia;
}
