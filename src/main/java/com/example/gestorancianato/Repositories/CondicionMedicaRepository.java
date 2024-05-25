package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.CondicionMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CondicionMedicaRepository extends JpaRepository<CondicionMedica, Integer> {

    @Override
    Optional<CondicionMedica> findById(Integer id);



}