package com.example.gestorancianato.Services;

import com.example.gestorancianato.Entities.Enfermero;

import java.util.List;
import java.util.Optional;

public interface EnfermeroService {
    Enfermero createEnfermero(Enfermero enfermero);

    List<Enfermero> getAllEnfermeros();

    List<Enfermero> getEnfermeroByCedula(Integer integer);

    Optional<Enfermero> updateEnfermero(Integer cedula, Enfermero enfermero);

    void deleteEnfermero(Integer cedula);

    List<Enfermero> getEnfermeroByNombreAndApellido(String nombre, String apellido);
}
