package com.example.gestorancianato.Mappers;

import com.example.gestorancianato.Dtos.CategoriaMedicamentoDto;
import com.example.gestorancianato.Entities.CategoriaMedicamento;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface CategoriaMedicamentoMapper {
    CategoriaMedicamentoDto toCategoriaMedicamentoDto(CategoriaMedicamento categoriaMedicamento);
    CategoriaMedicamento toCategoriaMedicamento(CategoriaMedicamentoDto categoriaMedicamentoDto);
}
