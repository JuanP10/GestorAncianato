package com.example.gestorancianato.Dtos;

import lombok.Data;

@Data

public class DonanteDto {
    private Integer cedula;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String direccion;

}
