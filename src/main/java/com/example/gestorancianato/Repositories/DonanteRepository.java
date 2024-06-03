package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.Donante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  DonanteRepository extends JpaRepository<Donante, Long> {
    Optional<Donante> findByNombreOrApellido(String nombre, String apellido);

    Optional<Donante> findByCedula(Long cedula);

}
