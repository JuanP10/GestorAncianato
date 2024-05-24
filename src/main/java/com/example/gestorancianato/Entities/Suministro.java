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
    private Integer id;
    private Integer adultoMayorID;
    private LocalDate fechaSuministro;
    private Integer cantidad;

    @ManyToMany
    @JoinTable(
            name = "suministro_medicamento",
            joinColumns = @JoinColumn(name = "suministro_id"),
            inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private List<Medicamento> listaMedicamentos = new ArrayList<>();

    @ManyToOne @JoinColumn(name = "idAdultoMayor")
    private AdultoMayor adultoMayor;
    
}
