package com.example.gestorancianato.Dtos;

import com.example.gestorancianato.Entities.Enfermero;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class EnfermeroDto {
    private Long cedula;
    private String nombre;
    private String apellido;

    @Enumerated(EnumType.STRING)
    private Enfermero.Rol rol;
    private String contrasena;
}
