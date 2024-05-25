package com.example.gestorancianato.Services.ServicesImp;


import com.example.gestorancianato.Entities.Enfermero;
import com.example.gestorancianato.Repositories.EnfermeroRepository;
import com.example.gestorancianato.Services.EnfermeroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EnfermeroServiceImp implements EnfermeroService {

    private final EnfermeroRepository enfermeroRepository;

    private static final Logger log = LoggerFactory.getLogger(EnfermeroService.class);

    public EnfermeroServiceImp(EnfermeroRepository enfermeroRepository) {
        this.enfermeroRepository = enfermeroRepository;
    }


    @Override
    public Enfermero createEnfermero(Enfermero enfermero) { return enfermeroRepository.save(enfermero); }

    @Override
    public List<Enfermero> getAllEnfermeros() {
        return enfermeroRepository.findAll();
    }

    @Override
    public List<Enfermero> getEnfermeroByCedula(Integer cedula) {
        return enfermeroRepository.findByCedula(cedula);
    }

    @Override
    public Optional<Enfermero> updateEnfermero(Integer cedula, Enfermero enfermero) {
        Optional<Enfermero> optionalEnfermero = enfermeroRepository.findById(cedula);
        if (optionalEnfermero.isPresent()) {
            Enfermero enfermeroToUpdate = optionalEnfermero.get();
            enfermeroToUpdate.setNombre(enfermero.getNombre());
            enfermeroToUpdate.setApellido(enfermero.getApellido());
            enfermeroToUpdate.setContrasena(enfermero.getContrasena());
            enfermeroToUpdate.setCedula(enfermero.getCedula());
            enfermeroToUpdate.setRol(enfermero.getRol());
            return Optional.of(enfermeroRepository.save(enfermeroToUpdate));
        } else {
            log.error("El Enfermero con cedula {} no existe", cedula);
            return Optional.empty();
        }
    }

    @Override
    public void deleteEnfermero(Integer cedula) { enfermeroRepository.deleteById(cedula);

    }

    @Override
    public List<Enfermero> getEnfermeroByNombreAndApellido(String nombre, String apellido) {
        return enfermeroRepository.findByNombreOrApellido(nombre, apellido);
    }
}

