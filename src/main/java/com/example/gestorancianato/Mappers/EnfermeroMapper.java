package com.example.gestorancianato.Mappers;

import com.example.gestorancianato.Dtos.EnfermeroDto;
import com.example.gestorancianato.Entities.Enfermero;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface EnfermeroMapper {
    EnfermeroDto toEnfermeroDto (Enfermero enfermero);
    Enfermero toEnfermero (EnfermeroDto enfermeroDto);
}
