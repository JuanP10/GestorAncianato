package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Entities.CondicionMedica;

import com.example.gestorancianato.Repositories.CondicionMedicaRepository;
import com.example.gestorancianato.Services.CondicionMedicaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service

public class CondicionMedicaImp implements CondicionMedicaService {

    private final CondicionMedicaRepository condicionMedicaRepository;

    private static final Logger log = LoggerFactory.getLogger(CondicionMedicaImp.class);

    public CondicionMedicaImp(CondicionMedicaRepository condicionMedicaRepository) {
        this.condicionMedicaRepository = condicionMedicaRepository;
    }


    @Override
    public CondicionMedica createCondicionMedica(CondicionMedica condicionMedica) {
        return condicionMedicaRepository.save(condicionMedica);
    }

    @Override
    public Optional<CondicionMedica> getCondicionMedicaById(Integer id) {
        return condicionMedicaRepository.findById(id);
    }

    @Override
    public Optional<CondicionMedica> updateCondicionMedica(Integer id, CondicionMedica condicionMedica) {
         Optional<CondicionMedica> optionalCondicionMedica = condicionMedicaRepository.findById(id);
        if (optionalCondicionMedica.isPresent()) {
            CondicionMedica CondicionMedicaToUpdate = optionalCondicionMedica.get();
            CondicionMedicaToUpdate.setCondicion(condicionMedica.getCondicion());
            return Optional.of(condicionMedicaRepository.save(CondicionMedicaToUpdate));
        } else {
            log.error("La Condicion Medica con id {} no existe", id);
            return Optional.empty();
        }

    }

    @Override
    public void deleteCondicionMedica(Integer id) {
        condicionMedicaRepository.deleteById(id);

    }

    @Override
    public List<CondicionMedica> getAllCondicionMedica() {
        return condicionMedicaRepository.findAll();
    }
}
