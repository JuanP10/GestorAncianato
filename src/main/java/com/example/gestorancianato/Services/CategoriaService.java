package com.example.gestorancianato.Services;

import com.example.gestorancianato.Entities.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    Optional<Categoria> getCategoriaById(Integer id);
    Categoria createCategoria(Categoria categoria);
    Optional<Categoria> updateCategoria(Integer id, Categoria categoria);
    void deleteCategoriaById(Integer id);
    List<Categoria> getAllCategorias();

}
