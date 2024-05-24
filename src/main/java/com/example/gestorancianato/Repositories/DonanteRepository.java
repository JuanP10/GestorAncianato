package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.Donante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface  DonanteRepository extends JpaRepository<Donante, Integer> {
    Optional<Donante> findByCedula(Integer integer);

    List<Donante> findByNombreAndApellido (String nombre, String apellido);



}
