package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.CatMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//@Repository
public interface CatMedicamentoRepository extends JpaRepository<CatMedicamento, Integer> {
    @Override
    Optional<CatMedicamento> findById(Integer integer);

}
