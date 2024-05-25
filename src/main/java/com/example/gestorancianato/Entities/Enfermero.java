package com.example.gestorancianato.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Enfermeros")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enfermero {
    @Id
    private int cedula;
    private String nombre;
    private String apellido;

    @Enumerated(EnumType.STRING)
    private Rol rol;
    private String contrasena;

    @OneToMany(mappedBy = "enfermero")
    private List<Suministro> suministros;

    public enum Rol {
        JEFE,
        AUXILIAR
    }
}
