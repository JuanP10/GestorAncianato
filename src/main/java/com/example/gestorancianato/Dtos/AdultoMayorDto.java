package com.example.gestorancianato.Dtos;

import lombok.Data;

import java.time.LocalDate;
@Data
public class AdultoMayorDto {
    private Integer cedula;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Boolean esPensionado;
}
