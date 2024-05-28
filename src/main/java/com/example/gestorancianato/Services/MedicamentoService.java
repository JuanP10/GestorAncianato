package com.example.gestorancianato.Services;


import com.example.gestorancianato.Dtos.MedicamentoDto;

import java.util.List;

public interface MedicamentoService {
    MedicamentoDto getMedicamentoById(Integer id);
    List<MedicamentoDto> getMedicamentosByCatMedicamentos(String categoria);

    List<MedicamentoDto> getMedicamentoByDonanteCedula(Integer cedula);
    List<MedicamentoDto> getMedicamentoByFechaVencimientoMesAndAño(int mes, int año);
    MedicamentoDto createMedicamento(MedicamentoDto medicamento);


    List<MedicamentoDto> getAllMedicamentos();
    MedicamentoDto updateMedicamento(Integer id, MedicamentoDto medicamento);
    void deleteMedicamentoById(Integer id);
}
