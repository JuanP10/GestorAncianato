package com.example.gestorancianato.Mappers;

import com.example.gestorancianato.Dtos.MedicamentoDto;
import com.example.gestorancianato.Entities.Medicamento;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface MedicamentoMapper {
    MedicamentoDto toMedicamentoDto (Medicamento medicamento);
    Medicamento toMedicamento (MedicamentoDto medicamentoDto);

}
