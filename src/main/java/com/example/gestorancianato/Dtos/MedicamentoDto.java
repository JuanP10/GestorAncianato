package com.example.gestorancianato.Dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicamentoDto {
    private int id;
    private String nombre;
    private int cantidad;
    private LocalDate fechaVencimiento;
}
