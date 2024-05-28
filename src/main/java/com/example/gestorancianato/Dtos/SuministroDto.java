package com.example.gestorancianato.Dtos;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SuministroDto {
    private int id;
    private int cantidad;
    private LocalDate fechaSuministro;
}
