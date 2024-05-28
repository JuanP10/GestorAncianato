package com.example.gestorancianato.Services;

import com.example.gestorancianato.Entities.CategoriaMedicamento;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    Optional<CategoriaMedicamento> getCategoriaById(Integer id);
    CategoriaMedicamento createCategoria(CategoriaMedicamento categoriaMedicamento);
    Optional<CategoriaMedicamento> updateCategoria(Integer id, CategoriaMedicamento categoriaMedicamento);
    void deleteCategoriaById(Integer id);
    List<CategoriaMedicamento> getAllCategorias();

}
