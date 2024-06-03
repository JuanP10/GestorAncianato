package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.Enfermero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EnfermeroRepository extends JpaRepository<Enfermero,Long> {

    List<Enfermero> findByCedula(Long cedula);

    List<Enfermero> findByNombreOrApellido(String nombre, String apellido);



}
