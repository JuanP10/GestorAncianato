package com.example.gestorancianato.Services;


import com.example.gestorancianato.Dtos.CategoriaMedicamentoDto;

import java.util.List;

public interface CategoriaMedicamentoService {

    CategoriaMedicamentoDto getCategoriaById(Long id);
    CategoriaMedicamentoDto createCategoria(CategoriaMedicamentoDto categoriaMedicamento);
    CategoriaMedicamentoDto updateCategoria(Long id, CategoriaMedicamentoDto categoriaMedicamento);
    void deleteCategoriaById(Long id);
    List<CategoriaMedicamentoDto> getAllCategorias();

}
