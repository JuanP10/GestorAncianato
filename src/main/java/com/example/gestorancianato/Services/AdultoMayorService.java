package com.example.gestorancianato.Services;


import com.example.gestorancianato.Dtos.AdultoMayorDto;

import java.util.List;

public interface AdultoMayorService {
    AdultoMayorDto createAdultoMayor(AdultoMayorDto adultoMayor);

    List<AdultoMayorDto> getAllAdultoMayor();

    AdultoMayorDto getAdultoMayorByCedula (Long cedula);

    AdultoMayorDto updateAdultoMayor(Long cedula, AdultoMayorDto adultoMayor);

    void deleteAdultoMayor(Long cedula);

    List<AdultoMayorDto> getAdultoMayorByNombreAndApellido(String nombre, String apellido);

    List<AdultoMayorDto> findByAdultoMayorByCondicionMedica(String CondicionMedica);


}
