package com.example.gestorancianato.Services;

import com.example.gestorancianato.Dtos.SuministroDto;

import java.util.List;
import java.time.LocalDate;


public interface SuministroService {

    SuministroDto createSuministro(SuministroDto suministro);

    List<SuministroDto> getAllSuministros();

    SuministroDto updateSuministro(Long id, SuministroDto suministro);

    void deleteSuministroById(Long id);

    SuministroDto getSuministroById(Long id);

    List<SuministroDto> getSuministrosByFecha(LocalDate fechaInicio, LocalDate fechaFin);

    List<SuministroDto> getSuministrosByMedicamento(String medicamento);

    List<SuministroDto> getSuministrosByAdultoMayor(Long cedula);
}
