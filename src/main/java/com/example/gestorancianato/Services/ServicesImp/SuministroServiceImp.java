package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Dtos.SuministroDto;
import com.example.gestorancianato.Entities.Suministro;
import com.example.gestorancianato.Mappers.SuministroMapper;
import com.example.gestorancianato.Repositories.SuministroRepository;
import com.example.gestorancianato.Services.SuministroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SuministroServiceImp implements SuministroService {

    private final SuministroRepository suministroRepository;
    private final SuministroMapper suministroMapper;

    public SuministroServiceImp(SuministroRepository suministroRepository, SuministroMapper suministroMapper) {
        this.suministroRepository = suministroRepository;
        this.suministroMapper = suministroMapper;
    }


    @Override
    public SuministroDto createSuministro(SuministroDto suministro) {
        return suministroMapper.toSuministroDto(suministroRepository.save(suministroMapper.toSuministro(suministro)));
    }

    @Override
    public List<SuministroDto> getAllSuministros() {
        List<Suministro> suministros = suministroRepository.findAll();
        return suministros.stream().map(suministroMapper::toSuministroDto).toList();
    }

    @Override
    public SuministroDto updateSuministro(Integer id, SuministroDto suministro) {
        Suministro suministroEntity = suministroMapper.toSuministro(suministro);
        Suministro suministroToUpdate = suministroRepository.findById(id).map(suministro1 -> {
            suministro1.setFechaSuministro(suministroEntity.getFechaSuministro());
            suministro1.setCantidad(suministroEntity.getCantidad());
            return suministroRepository.save(suministro1);
        }).orElseThrow(() -> new RuntimeException("Suministro no encontrado"));
        return suministroMapper.toSuministroDto(suministroToUpdate);
    }

    @Override
    public void deleteSuministroById(Integer id) {
        Suministro suministro = suministroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Suministro no encontrado"));
        suministroRepository.delete(suministro);

    }

    @Override
    public SuministroDto getSuministroById(Integer id) {
        Suministro suministro = suministroRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Suministro no encontrado"));
        return suministroMapper.toSuministroDto(suministro);
    }

    @Override
    public List<SuministroDto> getSuministrosByFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Suministro> suministros = suministroRepository.findByFechaSuministroBetween(fechaInicio, fechaFin);
        return suministros.stream().map(suministroMapper::toSuministroDto).toList();
    }

    @Override
    public List<SuministroDto> getSuministrosByMedicamento(String medicamento) {
        List<Suministro> suministros = suministroRepository.findSuministrosByMedicamento(medicamento);
        return suministros.stream().map(suministroMapper::toSuministroDto).toList();
    }

    @Override
    public List<SuministroDto> getSuministrosByAdultoMayor(Integer cedula) {
        List<Suministro> suministros = suministroRepository.findSuministrosByAdultoMayor_Cedula(cedula);
        return suministros.stream().map(suministroMapper::toSuministroDto).toList();
    }

}
