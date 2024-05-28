package com.example.gestorancianato.Services;


import com.example.gestorancianato.Dtos.CondicionMedicaDto;

import java.util.List;

public interface CondicionMedicaService {
    CondicionMedicaDto getCondicionById(Integer id);
    CondicionMedicaDto createCondicion(CondicionMedicaDto condicionMedica);
    CondicionMedicaDto updateCondicion(Integer id, CondicionMedicaDto condicionMedica);

    void deleteCondicionById(Integer id);
    List<CondicionMedicaDto> getAllCondiciones();

    CondicionMedicaDto getCondicionByNombre(String nombre);


}
