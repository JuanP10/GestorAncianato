package com.example.gestorancianato.Dtos;

import lombok.Data;

import java.util.List;

@Data

public class DonanteDto {
    private Long cedula;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String direccion;

}
