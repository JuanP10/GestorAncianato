package com.example.gestorancianato.Dtos;

import com.example.gestorancianato.Entities.CategoriaMedicamento;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class AdultoMayorDto {
    private Long cedula;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Boolean esPensionado;
    private Set<Long> idsCondicion;
}
