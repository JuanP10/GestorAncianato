package com.example.gestorancianato.Services;


import com.example.gestorancianato.Dtos.CondicionMedicaDto;

import java.util.List;

public interface CondicionMedicaService {
    CondicionMedicaDto getCondicionById(Long id);
    CondicionMedicaDto createCondicion(CondicionMedicaDto condicionMedica);
    CondicionMedicaDto updateCondicion(Long id, CondicionMedicaDto condicionMedica);

    void deleteCondicionById(Long id);
    List<CondicionMedicaDto> getAllCondiciones();

    CondicionMedicaDto getCondicionByNombre(String nombre);


}
