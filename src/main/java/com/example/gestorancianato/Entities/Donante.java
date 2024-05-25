package com.example.gestorancianato.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "Donantes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Donante {
    @Id
    private Integer cedula;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String direccion;

    @OneToMany(mappedBy = "donante")
    private List<Medicamento> medicamentos;
}
