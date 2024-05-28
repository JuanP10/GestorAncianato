package com.example.gestorancianato.Services;


import com.example.gestorancianato.Dtos.CategoriaMedicamentoDto;

import java.util.List;

public interface CategoriaMedicamentoService {

    CategoriaMedicamentoDto getCategoriaById(Integer id);
    CategoriaMedicamentoDto createCategoria(CategoriaMedicamentoDto categoriaMedicamento);
    CategoriaMedicamentoDto updateCategoria(Integer id, CategoriaMedicamentoDto categoriaMedicamento);
    void deleteCategoriaById(Integer id);
    List<CategoriaMedicamentoDto> getAllCategorias();

}
