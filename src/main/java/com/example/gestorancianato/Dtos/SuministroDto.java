package com.example.gestorancianato.Dtos;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SuministroDto {
    private Long id;
    private int cantidad;
    private LocalDate fechaSuministro;
}
