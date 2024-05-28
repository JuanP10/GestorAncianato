package com.example.gestorancianato.Mappers;

import com.example.gestorancianato.Dtos.DonanteDto;
import com.example.gestorancianato.Entities.Donante;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface DonanteMapper {
    DonanteDto toDonanteDto(Donante donante);
    Donante toDonante(DonanteDto donanteDto);
}
