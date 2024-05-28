package com.example.gestorancianato.Mappers;

import com.example.gestorancianato.Dtos.SuministroDto;
import com.example.gestorancianato.Entities.Suministro;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface SuministroMapper {
    SuministroDto toSuministroDto(Suministro suministro);
    Suministro toSuministro (SuministroDto suministroDto);
}
