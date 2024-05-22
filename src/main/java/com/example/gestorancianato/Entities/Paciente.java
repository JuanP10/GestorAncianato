package com.example.gestorancianato.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Paciente {
    @Id
    private String cedula;
}
