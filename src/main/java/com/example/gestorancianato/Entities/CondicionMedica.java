package com.example.gestorancianato.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Condiciones Medicas")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CondicionMedica {
    @EmbeddedId
    private CondicionMedicaId id;

    @ManyToOne
    @MapsId("adultoMayorCedula")
    @JoinColumn(name = "adultoMayorCedula")
    private AdultoMayor adultoMayor;

    @ManyToOne
    @MapsId("condicionID")
    @JoinColumn(name = "condicionID")
    private Condicion condicion;
}
@Embeddable
class CondicionMedicaId implements Serializable {
    private int adultoMayorCedula;
    private int condicionID;

}
