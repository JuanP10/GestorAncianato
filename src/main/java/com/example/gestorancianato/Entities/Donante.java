package com.example.gestorancianato.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Donante {
    @Id
    private String cedula;
    private String nombre;
    private String apellido;
}
