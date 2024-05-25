package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Entities.Condicion;
import com.example.gestorancianato.Repositories.CondicionRepository;
import com.example.gestorancianato.Services.CondicionService;
import com.example.gestorancianato.Services.EnfermeroService;
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
    public Optional<Condicion> getCondicionById(Integer id) {
        return condicionRepository.findById(id);
    }

    @Override
    public Condicion createCondicion(Condicion condicion) {
        return condicionRepository.save(condicion);
    }

    @Override
    public Optional<Condicion> updateCondicion(Integer id, Condicion condicion) {
        Optional<Condicion> optionalCondicion = condicionRepository.findById(id);
        if (optionalCondicion.isPresent()){
            Condicion condicionToUpdate = optionalCondicion.get();
            condicionToUpdate.setNombre(condicion.getNombre());
            condicionToUpdate.setCondicionesMedicas(condicion.getCondicionesMedicas());
            return Optional.of(condicionRepository.save(condicionToUpdate));

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
    public List<Condicion> getAllCondiciones() {
        return condicionRepository.findAll();
    }

    @Override
    public Optional<Condicion> getCondicionByNombre(String nombre) {
        return condicionRepository.findByNombre(nombre);
    }
}
