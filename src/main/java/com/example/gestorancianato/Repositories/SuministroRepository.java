package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.Suministro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface SuministroRepository extends JpaRepository<Suministro, Integer> {
    List<Suministro> findByFechaSuministroBetween(LocalDate startDate, LocalDate endDate);

    //Este es para listar los suministros por adulto mayor
    List<Suministro> findSuministrosByAdultoMayor_Cedula(Integer cedula);

    @Query ("SELECT s FROM Suministro s WHERE s.medicamento.nombre = :medicamento")
    List<Suministro> findSuministrosByMedicamento(String medicamento);
}