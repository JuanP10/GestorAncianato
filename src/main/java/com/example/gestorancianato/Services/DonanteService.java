package com.example.gestorancianato.Services;

import com.example.gestorancianato.Dtos.DonanteDto;
import com.example.gestorancianato.Entities.Donante;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DonanteService {
    DonanteDto createDonante (DonanteDto donante);

    List<DonanteDto> getAllDonantes();
    Optional<DonanteDto> getDonanteByCedula(Integer cedula);
    Optional<DonanteDto> updateDonante(Integer cedula, Donante donante);

    ResponseEntity<String> deleteDonante(Integer cedula);

    Optional<DonanteDto> getDonantesByNombreAndApellido(String nombre, String apellido);

}
