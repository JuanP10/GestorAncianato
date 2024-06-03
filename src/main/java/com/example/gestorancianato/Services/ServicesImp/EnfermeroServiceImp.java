package com.example.gestorancianato.Services.ServicesImp;


import com.example.gestorancianato.Dtos.EnfermeroDto;
import com.example.gestorancianato.Entities.Enfermero;
import com.example.gestorancianato.Mappers.EnfermeroMapper;
import com.example.gestorancianato.Repositories.EnfermeroRepository;
import com.example.gestorancianato.Services.EnfermeroService;

import org.springframework.stereotype.Service;
import java.util.List;


@Service

public class EnfermeroServiceImp implements EnfermeroService {

    private final EnfermeroRepository enfermeroRepository;
    private final EnfermeroMapper enfemeroMapper;

    public EnfermeroServiceImp(EnfermeroRepository enfermeroRepository, EnfermeroMapper enfemeroMapper) {
        this.enfermeroRepository = enfermeroRepository;
        this.enfemeroMapper = enfemeroMapper;
    }


    @Override
    public EnfermeroDto createEnfermero(EnfermeroDto enfermero) {
        Enfermero enfermeroEntity = enfemeroMapper.toEnfermero(enfermero);
        return enfemeroMapper.toEnfermeroDto(enfermeroRepository.save(enfermeroEntity));
    }

    @Override
    public List<EnfermeroDto> getAllEnfermeros() {
        List<Enfermero> enfermeros = enfermeroRepository.findAll();
        return enfermeros.stream().map(enfemeroMapper::toEnfermeroDto).toList();
    }

    @Override
    public List<EnfermeroDto> getEnfermeroByCedula(Long cedula) {
       List<Enfermero> enfermeros = enfermeroRepository.findByCedula(cedula);
       return enfermeros.stream().map(enfemeroMapper::toEnfermeroDto).toList();
    }

    @Override
    public EnfermeroDto updateEnfermero(Long cedula, EnfermeroDto enfermero) {
        Enfermero enfermeroEntity = enfemeroMapper.toEnfermero(enfermero);
        Enfermero enfermeroToUpdate = enfermeroRepository.findById(cedula).map(enfermeroEncontrado -> {
            enfermeroEncontrado.setNombre(enfermeroEntity.getNombre());
            enfermeroEncontrado.setApellido(enfermeroEntity.getApellido());
            enfermeroEncontrado.setRol(enfermeroEntity.getRol());
            enfermeroEncontrado.setContrasena(enfermeroEntity.getContrasena());
            return enfermeroRepository.save(enfermeroEncontrado);
        }).orElseThrow(() -> new RuntimeException("Enfermero no encontrado"));

        return enfemeroMapper.toEnfermeroDto(enfermeroToUpdate);

    }

    @Override
    public void deleteEnfermero(Long cedula) {
        Enfermero enfermero = enfermeroRepository.findById(cedula).orElseThrow(() -> new RuntimeException("Enfermero no encontrado"));
        enfermeroRepository.deleteById(cedula);
    }

    @Override
    public List<EnfermeroDto> getEnfermeroByNombreAndApellido(String nombre, String apellido) {
        List<Enfermero> enfermeros = enfermeroRepository.findByNombreOrApellido(nombre, apellido);
        return enfermeros.stream().map(enfemeroMapper::toEnfermeroDto).toList();
    }
}

