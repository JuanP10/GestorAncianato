package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.Condicion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CondicionRepository extends JpaRepository<Condicion, Integer> {

    @Override
    Optional<Condicion> findById(Integer integer);


}
