package com.example.gestorancianato.Services;

import com.example.gestorancianato.Entities.Donante;

import java.util.List;
import java.util.Optional;

public interface DonanteService {
    Donante createDonante(Donante donante);

    List<Donante> getAllDonantes();
    Optional<Donante> getDonanteByCedula(Integer cedula);
    Optional<Donante> updateDonante(Integer cedula, Donante donante);

    void deleteDonante(Integer cedula);

    List<Donante> getDonantesByNombreAndApellido(String nombre, String apellido);

}
