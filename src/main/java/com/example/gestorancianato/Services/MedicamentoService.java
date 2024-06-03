package com.example.gestorancianato.Services;


import com.example.gestorancianato.Dtos.MedicamentoDto;
import com.example.gestorancianato.Entities.Medicamento;
import com.example.gestorancianato.Exepciones.CategoriaMedicamentoNotFoundException;

import java.util.List;
import java.util.Optional;

public interface MedicamentoService {
    MedicamentoDto getMedicamentoById(Long id);
    List<MedicamentoDto> getMedicamentosByCatMedicamentos(String categoria);

    List<MedicamentoDto> getMedicamentoByDonanteCedula(Long cedula);
    List<MedicamentoDto> getMedicamentoByFechaVencimientoMesAndAño(int mes, int año);
    MedicamentoDto createMedicamento(MedicamentoDto medicamento);


    List<MedicamentoDto> getAllMedicamentos();
    MedicamentoDto updateMedicamento(Long id, MedicamentoDto medicamentoDto);
    void deleteMedicamentoById(Long id);
}
