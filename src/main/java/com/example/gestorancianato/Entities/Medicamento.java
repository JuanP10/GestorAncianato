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
    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private LocalDate fechaVencimiento;

    @ElementCollection(targetClass = Categoria.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "medicamento_categoria", joinColumns = @JoinColumn(name = "medicamento_id"))
    @Column(name = "categoria")
    private Set<Categoria> categorias;
    private Integer cantidad;

    @ManyToOne @JoinColumn(name = "idDonante")
    private Donante donante;

    @ManyToMany(mappedBy = "listaMedicamentos")
    private List<Suministro> users = new ArrayList<>();


    public enum Categoria {
        ANALGESICO,
        ANTIBIOTICO,
        ANTIINFLAMATORIO,
        ANTISEPTICO,
        ANESTESICO,
        ANTIVIRAL,
        ANTIFUNGICO,
        ANTIPARASITARIO,
        ANTIEMETICO,
        ANTIACIDO,
        ANTIALERGICO,
        ANTICOAGULANTE,
        LAXANTE,
        HIPOTENSOR,
        HIPERTENSOR,
        DIURETICO,
        HORMONAL,
        VITAMINA,
        MINERAL,
        SUPLEMENTO_DIETETICO,
        OTRO
    }
}


