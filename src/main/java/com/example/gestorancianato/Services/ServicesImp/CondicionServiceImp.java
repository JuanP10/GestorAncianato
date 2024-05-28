package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Entities.CondicionMedica;
import com.example.gestorancianato.Repositories.CondicionRepository;
import com.example.gestorancianato.Services.CondicionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service

public class CondicionServiceImp implements CondicionService {

    private final CondicionRepository condicionRepository;

    private static final Logger log = LoggerFactory.getLogger(CondicionServiceImp.class);

    public CondicionServiceImp(CondicionRepository condicionRepository) {
        this.condicionRepository = condicionRepository;
    }

    @Override
    public Optional<CondicionMedica> getCondicionById(Integer id) {
        return condicionRepository.findById(id);
    }

    @Override
    public CondicionMedica createCondicion(CondicionMedica condicionMedica) {
        return condicionRepository.save(condicionMedica);
    }

    @Override
    public Optional<CondicionMedica> updateCondicion(Integer id, CondicionMedica condicionMedica) {
        Optional<CondicionMedica> optionalCondicion = condicionRepository.findById(id);
        if (optionalCondicion.isPresent()){
            CondicionMedica condicionMedicaToUpdate = optionalCondicion.get();
            condicionMedicaToUpdate.setNombre(condicionMedica.getNombre());
            condicionMedicaToUpdate.setAdultosMayores(condicionMedica.getAdultosMayores());
            return Optional.of(condicionRepository.save(condicionMedicaToUpdate));

        } else{
            log.error("La condicion con id {} no existe", id);
            return Optional.empty();
        }
    }

    @Override
    public void deleteCondicionById(Integer id) {
        condicionRepository.deleteById(id);
    }

    @Override
    public List<CondicionMedica> getAllCondiciones() {
        return condicionRepository.findAll();
    }

    @Override
    public Optional<CondicionMedica> getCondicionByNombre(String nombre) {
        return condicionRepository.findByNombre(nombre);
    }
}
