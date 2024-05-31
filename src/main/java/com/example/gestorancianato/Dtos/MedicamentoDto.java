package com.example.gestorancianato.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MedicamentoDto {
    private int id;
    private String nombre;
    private int cantidad;
    private LocalDate fechaVencimiento;
    private String cedulaDonante;
    private DonanteDto donante;
}
