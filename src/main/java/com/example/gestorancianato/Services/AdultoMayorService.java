package com.example.gestorancianato.Services;


import com.example.gestorancianato.Dtos.AdultoMayorDto;

import java.util.List;

public interface AdultoMayorService {
    AdultoMayorDto createAdultoMayor(AdultoMayorDto adultoMayor);

    List<AdultoMayorDto> getAllAdultoMayor();

    AdultoMayorDto getAdultoMayorByCedula (Integer cedula);

    AdultoMayorDto updateAdultoMayor(Integer cedula, AdultoMayorDto adultoMayor);

    void deleteAdultoMayor(Integer cedula);

    List<AdultoMayorDto> getAdultoMayorByNombreAndApellido(String nombre, String apellido);

    List<AdultoMayorDto> findByAdultoMayorByCondicionMedica(String CondicionMedica);


}
