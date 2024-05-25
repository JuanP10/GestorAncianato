package com.example.gestorancianato.Services;

import com.example.gestorancianato.Entities.Medicamento;

import java.util.List;
import java.util.Optional;

public interface MedicamentoService {
    Optional<Medicamento> getMedicamentoById(Integer id);
    List<Medicamento> getMedicamentosByCatMedicamentos(String categoria);

    List<Medicamento> getMedicamentoByDonanteCedula(Integer cedula);
    List<Medicamento> getMedicamentoByFechaVencimientoMesAndAño(int mes, int año);
    Medicamento createMedicamento(Medicamento medicamento);


    List<Medicamento> getAllMedicamentos();
    Optional<Medicamento> updateMedicamento(Integer id, Medicamento medicamento);
    void deleteMedicamentoById(Integer id);
}
