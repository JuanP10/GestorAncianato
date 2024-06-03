package com.example.gestorancianato.Services;

import com.example.gestorancianato.Dtos.EnfermeroDto;

import java.util.List;

public interface EnfermeroService {
    EnfermeroDto createEnfermero(EnfermeroDto enfermero);

    List<EnfermeroDto> getAllEnfermeros();

    List<EnfermeroDto> getEnfermeroByCedula(Long integer);

    EnfermeroDto updateEnfermero(Long cedula, EnfermeroDto enfermero);

    void deleteEnfermero(Long cedula);

    List<EnfermeroDto> getEnfermeroByNombreAndApellido(String nombre, String apellido);
}
