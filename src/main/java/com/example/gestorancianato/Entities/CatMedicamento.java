package com.example.gestorancianato.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Categorias Medicas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatMedicamento {
    @EmbeddedId
    private CatMedicamentoId id;

    @ManyToOne
    @MapsId("medicamentoID")
    @JoinColumn(name = "medicamentoID")
    private Medicamento medicamento;

    @ManyToOne
    @MapsId("categoriaID")
    @JoinColumn(name = "categoriaID")
    private Categoria categoria;
}

@Embeddable
class CatMedicamentoId implements Serializable {
    private int medicamentoID;
    private int categoriaID;
}
