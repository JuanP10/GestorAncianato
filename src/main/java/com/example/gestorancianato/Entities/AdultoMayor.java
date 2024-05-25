package com.example.gestorancianato.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Adultos_Mayores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdultoMayor {
    @Id
    private Integer cedula;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private Boolean esPensionado;

    @OneToMany(mappedBy = "adultomayor")
    private List<Suministro> suministroList;

    @OneToMany(mappedBy = "adultoMayor")
    private List<Suministro> suministros;

    @OneToMany(mappedBy = "adultoMayor")
    private List<CondicionMedica> condicionesMedicas;



}
