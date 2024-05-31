package com.example.gestorancianato.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Medicamentos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Medicamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int cantidad;
    private LocalDate fechaVencimiento;

    @ManyToOne
    @JoinColumn(name = "donanteID")
    @JsonBackReference
    private Donante donante;

    @ManyToMany
    @JoinTable(
            name = "Medicamento_Categoria",
            joinColumns = @JoinColumn(name = "medicamento_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<CategoriaMedicamento> categoriasMedicamentos;

    @OneToMany(mappedBy = "medicamento")
    private List<Suministro> suministros;

    public Medicamento updateMedicamento (Medicamento medicamento){
        return new Medicamento(medicamento.getId(), medicamento.getNombre(), medicamento.getCantidad(), medicamento.getFechaVencimiento(), medicamento.getDonante(), medicamento.getCategoriasMedicamentos(), medicamento.getSuministros());
    }
}


