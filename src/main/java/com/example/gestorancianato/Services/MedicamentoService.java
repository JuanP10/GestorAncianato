package com.example.gestorancianato.Services;


import com.example.gestorancianato.Dtos.MedicamentoDto;
import com.example.gestorancianato.Entities.Medicamento;

import java.util.List;
import java.util.Optional;

public interface MedicamentoService {
    MedicamentoDto getMedicamentoById(Integer id);
    List<MedicamentoDto> getMedicamentosByCatMedicamentos(String categoria);

    List<MedicamentoDto> getMedicamentoByDonanteCedula(Integer cedula);
    List<MedicamentoDto> getMedicamentoByFechaVencimientoMesAndAño(int mes, int año);
    MedicamentoDto createMedicamento(MedicamentoDto medicamento);


    List<MedicamentoDto> getAllMedicamentos();
    Optional<MedicamentoDto> updateMedicamento(Integer id, Medicamento medicamento);
    void deleteMedicamentoById(Integer id);
}
