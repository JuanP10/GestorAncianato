package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.AdultoMayor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdultoMayorRepository extends JpaRepository<AdultoMayor,Integer> {

    Optional<AdultoMayor> findByCedula (Integer cedula);

    Optional<AdultoMayor> getAdultoMayorByCondicionesMedicas (String condicionesMedicas);

    List<AdultoMayor> findByNombreOrApellido(String nombre, String apellido);


}