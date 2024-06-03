package com.example.gestorancianato.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Medicamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Medicamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int cantidad;
    private LocalDate fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "cedula_donante")
    private Donante donante;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Medicamento_Categoria",
            joinColumns = @JoinColumn(name = "medicamento_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<CategoriaMedicamento> categoriaMedicamento = new HashSet<>();

}


