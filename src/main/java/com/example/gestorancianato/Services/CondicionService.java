package com.example.gestorancianato.Services;

import com.example.gestorancianato.Entities.CondicionMedica;

import java.util.List;
import java.util.Optional;

public interface CondicionService {
    Optional<CondicionMedica> getCondicionById(Integer id);
    CondicionMedica createCondicion(CondicionMedica condicionMedica);
    Optional<CondicionMedica> updateCondicion(Integer id, CondicionMedica condicionMedica);

    void deleteCondicionById(Integer id);
    List<CondicionMedica> getAllCondiciones();

    Optional<CondicionMedica> getCondicionByNombre(String nombre);


}
