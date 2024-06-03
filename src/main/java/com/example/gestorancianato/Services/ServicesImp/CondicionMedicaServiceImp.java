package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Dtos.CondicionMedicaDto;
import com.example.gestorancianato.Entities.CondicionMedica;
import com.example.gestorancianato.Mappers.CondicionMedicaMapper;
import com.example.gestorancianato.Repositories.CondicionMedicaRepository;
import com.example.gestorancianato.Services.CondicionMedicaService;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service

public class CondicionMedicaServiceImp implements CondicionMedicaService {

    private final CondicionMedicaRepository condicionMedicaRepository;
    private  final CondicionMedicaMapper condicionMedicaMapper;

    public CondicionMedicaServiceImp(CondicionMedicaRepository condicionMedicaRepository, CondicionMedicaMapper condicionMedicaMapper) {
        this.condicionMedicaRepository = condicionMedicaRepository;
        this.condicionMedicaMapper = condicionMedicaMapper;
    }

    @Override
    public CondicionMedicaDto getCondicionById (Long id) {
        CondicionMedica condicionMedica = condicionMedicaRepository.findById(id).orElseThrow(()-> new RuntimeException("Condicion no encontrada con id: "+id));
        return condicionMedicaMapper.toCondicionMedicaDto(condicionMedica);
    }

    @Override
    public CondicionMedicaDto createCondicion(CondicionMedicaDto condicionMedica) {
        CondicionMedica condicionMedicaEntity = condicionMedicaMapper.toCondicionMedica(condicionMedica);
        return condicionMedicaMapper.toCondicionMedicaDto(condicionMedicaRepository.save(condicionMedicaEntity));
    }

    @Override
    public CondicionMedicaDto updateCondicion (Long id, CondicionMedicaDto condicionMedica) {
        CondicionMedica condicionMedicaEntity = condicionMedicaMapper.toCondicionMedica(condicionMedica);
        CondicionMedica condicionMedicaToUpdate = condicionMedicaRepository.findById(id).map(condicionMedica1 -> {
            condicionMedica1.setNombre(condicionMedicaEntity.getNombre());
            return condicionMedicaRepository.save(condicionMedica1);
        }).orElseThrow(()-> new RuntimeException("Condicion no encontrada con id: "+id));
        return condicionMedicaMapper.toCondicionMedicaDto(condicionMedicaToUpdate);
    }

    @Override
    public void deleteCondicionById(Long id) {
        CondicionMedica condicionMedica = condicionMedicaRepository.findById(id).orElseThrow(() -> new RuntimeException("Condicion no encontrada con id: "+id));
        condicionMedicaRepository.delete(condicionMedica);
    }

    @Override
    public List<CondicionMedicaDto> getAllCondiciones() {
        List<CondicionMedica> condicionMedicas = condicionMedicaRepository.findAll();
        return condicionMedicas.stream().map(condicionMedicaMapper::toCondicionMedicaDto).toList();
    }

    @Override
    public CondicionMedicaDto getCondicionByNombre(String nombre) {
        CondicionMedica condicionMedica = condicionMedicaRepository.findByNombre(nombre);
        return condicionMedicaMapper.toCondicionMedicaDto(condicionMedica);
    }
}
