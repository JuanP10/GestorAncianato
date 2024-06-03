package com.example.gestorancianato.Services;

import com.example.gestorancianato.Dtos.DonanteDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface DonanteService {
    DonanteDto createDonante (DonanteDto donante);

    List<DonanteDto> getAllDonantes();
    Optional<DonanteDto> getDonanteByCedula(Long cedula);
    DonanteDto updateDonante (Long cedula, DonanteDto donante);

    ResponseEntity<String> deleteDonante(Long cedula);

    Optional<DonanteDto> getDonantesByNombreAndApellido(String nombre, String apellido);

}
