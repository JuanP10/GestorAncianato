package com.example.gestorancianato.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "Suministros")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Suministro{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cantidad;
    private LocalDate fechaSuministro;

    @ManyToOne
    @JoinColumn(name = "medicamentoID")
    private Medicamento medicamento;

    @ManyToOne
    @JoinColumn(name = "adultoMayorID")
    private AdultoMayor adultoMayor;

    @ManyToOne
    @JoinColumn(name = "enfermeroID")
    private Enfermero enfermero;
    
}
