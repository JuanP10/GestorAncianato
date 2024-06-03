package com.example.gestorancianato.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "Donantes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Donante {
    @Id @Column(unique = true) private Long cedula;
    private String nombre;
    private String apellido;
    private Long telefono;
    private String direccion;

    @OneToMany(mappedBy = "donante", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Medicamento> medicamentos = new HashSet<>();

}
