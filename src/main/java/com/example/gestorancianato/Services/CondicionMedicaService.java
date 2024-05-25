package com.example.gestorancianato.Services;

import com.example.gestorancianato.Entities.CondicionMedica;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CondicionMedicaService {

    CondicionMedica createCondicionMedica(CondicionMedica condicionMedica);

    Optional<CondicionMedica> getCondicionMedicaById(Integer id);

    Optional<CondicionMedica> updateCondicionMedica(Integer id, CondicionMedica condicionMedica);

    void deleteCondicionMedica(Integer id);

    List<CondicionMedica> getAllCondicionMedica();
}
