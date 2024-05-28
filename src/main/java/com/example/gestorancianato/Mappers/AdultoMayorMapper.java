package com.example.gestorancianato.Mappers;

import com.example.gestorancianato.Dtos.AdultoMayorDto;
import com.example.gestorancianato.Entities.AdultoMayor;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface AdultoMayorMapper {
    AdultoMayorDto toAdultoMayorDto(AdultoMayor adultoMayor);
    AdultoMayor toAdultoMayor(AdultoMayorDto adultoMayorDto);
}
