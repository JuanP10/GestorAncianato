package com.example.gestorancianato.Services;

import com.example.gestorancianato.Entities.Condicion;

import java.util.List;
import java.util.Optional;

public interface CondicionService {
    Optional<Condicion> getCondicionById(Integer id);
    Condicion createCondicion(Condicion condicion);
    Optional<Condicion> updateCondicion(Integer id, Condicion condicion);

    void deleteCondicionById(Integer id);
    List<Condicion> getAllCondiciones();

    Optional<Condicion> getCondicionByNombre(String nombre);


}
