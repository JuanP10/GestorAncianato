package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.Donante;
import com.example.gestorancianato.Entities.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicamentoRepository extends JpaRepository<Medicamento, String> {
    Optional<Medicamento> findById (Integer id);
    List<Medicamento> findByCategorias (String categorias);
    Optional<Medicamento> findByDonante (Donante donante);

    void deleteById(Integer id);

}
