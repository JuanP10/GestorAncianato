package com.example.gestorancianato.Services;

import com.example.gestorancianato.Entities.Medicamento;

import java.util.List;
import java.util.Optional;

public interface MedicamentoService {
    Medicamento createMedicamento(Medicamento medicamento);
    Optional<Medicamento> getMedicamentoById(Integer id);
    List<Medicamento> getMedicamentoByCategorias(String categorias);


    List<Medicamento> getAllMedicamentos();
    Optional<Medicamento> updateMedicamento(Integer id, Medicamento medicamento);
    void deleteMedicamento(Integer id);
}
