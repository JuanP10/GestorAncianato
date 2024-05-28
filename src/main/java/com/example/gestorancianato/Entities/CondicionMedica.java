package com.example.gestorancianato.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Condiciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CondicionMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    @ManyToMany(mappedBy = "condicionesMedicas")
    private List<AdultoMayor> adultosMayores;

}
