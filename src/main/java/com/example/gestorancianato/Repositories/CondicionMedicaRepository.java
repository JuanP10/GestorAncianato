package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.CondicionMedica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CondicionMedicaRepository extends JpaRepository<CondicionMedica, Integer> {

    CondicionMedica findByNombre(String nombre);


}
