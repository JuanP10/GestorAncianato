package com.example.gestorancianato.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Adultos_Mayores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdultoMayor {
    @Id
    private Long cedula;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Boolean esPensionado;

    @OneToMany(mappedBy = "adultoMayor")
    private Set<Suministro> suministros;

    @ManyToMany
    @JoinTable(
            name = "Adulto_Condicion",
            joinColumns = @JoinColumn(name = "adulto_id"),
            inverseJoinColumns = @JoinColumn(name = "condicion_id"))
    private Set<CondicionMedica> condicionesMedicas = new HashSet<>();


}
