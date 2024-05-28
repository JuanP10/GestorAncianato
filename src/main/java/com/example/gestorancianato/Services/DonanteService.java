package com.example.gestorancianato.Services;

import com.example.gestorancianato.Dtos.DonanteDto;
import com.example.gestorancianato.Entities.Donante;

import java.util.List;
import java.util.Optional;

public interface DonanteService {
    DonanteDto createDonante (DonanteDto donante);

    List<DonanteDto> getAllDonantes();
    DonanteDto getDonanteByCedula(Integer cedula);
    DonanteDto updateDonante(Integer cedula, DonanteDto donante);

    void deleteDonante(Integer cedula);

    List<DonanteDto> getDonantesByNombreAndApellido(String nombre, String apellido);

}
