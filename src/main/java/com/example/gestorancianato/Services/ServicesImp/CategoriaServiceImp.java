package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Entities.Categoria;
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
    public Optional<Categoria> getCategoriaById(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria createCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> updateCategoria(Integer id, Categoria categoria) {
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);
        if (optionalCategoria.isPresent()) {
            Categoria existingCategoria = optionalCategoria.get();
            existingCategoria.setNombreCat(categoria.getNombreCat());
            existingCategoria.setCatMedicamentos(categoria.getCatMedicamentos());
            return Optional.of(categoriaRepository.save(existingCategoria));
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
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }
}
