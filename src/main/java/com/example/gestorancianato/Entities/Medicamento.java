package com.example.gestorancianato.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Medicamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int cantidad;
    private LocalDate fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "donanteID")
    private Donante donante;

    @OneToMany(mappedBy = "medicamento")
    private List<CatMedicamento> catMedicamentos;

    @OneToMany(mappedBy = "medicamento")
    private List<Suministro> suministros;
}


