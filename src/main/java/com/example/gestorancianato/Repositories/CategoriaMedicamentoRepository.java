package com.example.gestorancianato.Repositories;

import com.example.gestorancianato.Entities.CategoriaMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaMedicamentoRepository extends JpaRepository<CategoriaMedicamento, Long> {

}
