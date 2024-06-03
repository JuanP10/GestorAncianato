package com.example.gestorancianato.Dtos;

import lombok.Data;


import java.time.LocalDate;

import java.util.Set;

@Data

public class MedicamentoDto {
    private Long id;
    private String nombre;
    private int cantidad;
    private LocalDate fechaVencimiento;
    private Long cedulaDonante;
    private Set<Long> idsCategorias;


}
