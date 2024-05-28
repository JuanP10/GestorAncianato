package com.example.gestorancianato.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Table(name = "Categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoriaMedicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreCat;

    @ManyToMany(mappedBy = "categoriasMedicamentos")
    private List<Medicamento> medicamentos;


}
