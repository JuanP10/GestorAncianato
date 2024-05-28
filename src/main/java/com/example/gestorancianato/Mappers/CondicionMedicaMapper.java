package com.example.gestorancianato.Mappers;

import com.example.gestorancianato.Dtos.CondicionMedicaDto;
import com.example.gestorancianato.Entities.CondicionMedica;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface CondicionMedicaMapper {
    CondicionMedicaDto toCondicionMedicaDto(CondicionMedica condicionMedica);
    CondicionMedica toCondicionMedica(CondicionMedicaDto condicionMedicaDto);
}
