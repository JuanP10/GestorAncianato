package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.Donante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface  DonanteRepository extends JpaRepository<Donante, Integer> {
    List<Donante> findByNombreOrApellido(String nombre, String apellido);

}
