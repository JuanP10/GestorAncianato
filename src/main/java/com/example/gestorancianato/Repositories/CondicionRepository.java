package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.CondicionMedica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CondicionRepository extends JpaRepository<CondicionMedica, Integer> {

    @Override
    Optional<CondicionMedica> findById(Integer integer);

    Optional<CondicionMedica> findByNombre(String nombre);


}
