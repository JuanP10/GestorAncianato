package com.example.gestorancianato.Services;

import com.example.gestorancianato.Entities.CatMedicamento;

import java.util.List;
import java.util.Optional;

public interface CatMedicamentoService {
    CatMedicamento createCatMedicamento(CatMedicamento catMedicamento);
    Optional<CatMedicamento> getCatMedicamentoById(Integer id);
    Optional<CatMedicamento> updateCatMedicamento (Integer id, CatMedicamento catMedicamento);
    void deleteCatMedicamento(Integer id);
    Optional<CatMedicamento> getCatMedicamentoByCategoria(String categoria);
    Optional<CatMedicamento> getCatMedicamentoByMedicamento(String medicamento);

    List<CatMedicamento> getAllCatMedicamentos();

}
