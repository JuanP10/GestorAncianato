package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Entities.CategoriaMedicamento;
import com.example.gestorancianato.Repositories.CategoriaRepository;
import com.example.gestorancianato.Services.CategoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImp implements CategoriaService {

    private CategoriaRepository categoriaRepository;

    @Autowired

    public CategoriaServiceImp(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }
    private static final Logger log = LoggerFactory.getLogger(CategoriaServiceImp.class);

    @Override
    public Optional<CategoriaMedicamento> getCategoriaById(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public CategoriaMedicamento createCategoria(CategoriaMedicamento categoriaMedicamento) {
        return categoriaRepository.save(categoriaMedicamento);
    }

    @Override
    public Optional<CategoriaMedicamento> updateCategoria(Integer id, CategoriaMedicamento categoriaMedicamento) {
        Optional<CategoriaMedicamento> optionalCategoria = categoriaRepository.findById(id);
        if (optionalCategoria.isPresent()) {
            CategoriaMedicamento existingCategoriaMedicamento = optionalCategoria.get();
            existingCategoriaMedicamento.setNombreCat(categoriaMedicamento.getNombreCat());
            existingCategoriaMedicamento.setNombreCat(categoriaMedicamento.getNombreCat());
            return Optional.of(categoriaRepository.save(existingCategoriaMedicamento));
        } else {
            log.error("La categoria con id {} no existe", id);
            return Optional.empty();
        }
    }

    @Override
    public void deleteCategoriaById(Integer id) {
        categoriaRepository.deleteById(id);

    }

    @Override
    public List<CategoriaMedicamento> getAllCategorias() {
        return categoriaRepository.findAll();
    }
}
