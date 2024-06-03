package com.example.gestorancianato.Mappers;

import com.example.gestorancianato.Dtos.MedicamentoDto;
import com.example.gestorancianato.Entities.CategoriaMedicamento;
import com.example.gestorancianato.Entities.Medicamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Set;
import java.util.stream.Collectors;


@Mapper (componentModel = "spring")
public interface MedicamentoMapper {

    @Mappings({
            @Mapping(source = "donante.cedula", target = "cedulaDonante"),
            @Mapping(target = "idsCategorias", expression = "java(mapCategoriasToIds(medicamento.getCategoriaMedicamento()))")
    })
    MedicamentoDto toMedicamentoDto(Medicamento medicamento);
    @Mappings({
            @Mapping(source = "cedulaDonante", target = "donante.cedula"),
            @Mapping(target = "categoriaMedicamento", ignore = true)
    })
    Medicamento toMedicamento (MedicamentoDto medicamentoDto);

    default Set<Long> mapCategoriasToIds (Set<CategoriaMedicamento> categorias) {
        return categorias.stream().map(CategoriaMedicamento::getId).collect(Collectors.toSet());
    }

}
