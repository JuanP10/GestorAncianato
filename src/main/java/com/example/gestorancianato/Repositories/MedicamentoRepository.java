package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, String> {
    Optional<Medicamento> findById (Integer id);
    List<Medicamento> findByCatMedicamentos (String catMedicamento);

    @Query("SELECT m FROM Medicamento m WHERE m.donante.cedula = :cedula")
    List<Medicamento> findByDonanteCedula(@Param("cedula") Integer cedula);

    //Busca por mes y año de nacimiento
    @Query("SELECT m FROM Medicamento m WHERE MONTH(m.fechaVencimiento) = :mes AND YEAR(m.fechaVencimiento) = :año")
    List<Medicamento> findByFechaVencimientoMesAndAño(@Param("mes") int mes, @Param("año") int año);

    void deleteById(Integer id);
}
