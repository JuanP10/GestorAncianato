package com.example.gestorancianato.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "Donantes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Donante {
    @Id @Column(unique = true) private Integer cedula;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String direccion;

    @OneToMany(mappedBy = "donante")
    @JsonManagedReference
    private List<Medicamento> medicamentos;

    public Donante updateDonante (Donante donante){
        return new Donante(donante.getCedula(), donante.getNombre(), donante.getApellido(), donante.getTelefono(), donante.getDireccion(), donante.getMedicamentos());
    }
}
