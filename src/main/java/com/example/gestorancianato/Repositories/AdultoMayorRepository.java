package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.AdultoMayor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdultoMayorRepository extends JpaRepository<AdultoMayor,Integer> {

    Optional<AdultoMayor> findByCedula (Integer cedula);

    @Query("SELECT a FROM AdultoMayor a JOIN a.condicionesMedicas c WHERE c.condicion = :nombreCondicion")
    List<AdultoMayor> findAdultosMayoresByCondicionMedica(@Param("nombreCondicion") String nombreCondicion);

    List<AdultoMayor> findByNombreOrApellido(String nombre, String apellido);


}