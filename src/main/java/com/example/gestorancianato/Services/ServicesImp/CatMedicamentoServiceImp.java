package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Entities.CatMedicamento;
import com.example.gestorancianato.Services.CatMedicamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatMedicamentoServiceImp implements CatMedicamentoService {

    private final CatMedicamentoService catMedicamentoService;

    private static final Logger log = LoggerFactory.getLogger(CatMedicamentoServiceImp.class);

    public CatMedicamentoServiceImp(CatMedicamentoService catMedicamentoService) {
        this.catMedicamentoService = catMedicamentoService;
    }


    @Override
    public CatMedicamento createCatMedicamento(CatMedicamento catMedicamento) {
        return  catMedicamentoService.createCatMedicamento(catMedicamento);
    }

    @Override
    public Optional<CatMedicamento> getCatMedicamentoById(Integer id) {
        return catMedicamentoService.getCatMedicamentoById(id);
    }

    @Override
    public Optional<CatMedicamento> updateCatMedicamento(Integer id, CatMedicamento catMedicamento) {
        Optional<CatMedicamento> optionalCatMedicamento = catMedicamentoService.getCatMedicamentoById(id);
        if (optionalCatMedicamento.isPresent()) {
            CatMedicamento catMedicamentoToUpdate = optionalCatMedicamento.get();
            catMedicamentoToUpdate.setCategoria(catMedicamento.getCategoria());
            catMedicamentoToUpdate.setMedicamento(catMedicamento.getMedicamento());
            return Optional.of(catMedicamentoService.createCatMedicamento(catMedicamentoToUpdate));
        } else {
            log.error("La categoria Medicamento con id {} no existe", id);
            return Optional.empty();
        }

    }

    @Override
    public void deleteCatMedicamento(Integer id) {
        catMedicamentoService.deleteCatMedicamento(id);
    }

    @Override
    public Optional<CatMedicamento> getCatMedicamentoByCategoria(String categoria) {
        return catMedicamentoService.getCatMedicamentoByCategoria(categoria);
    }

    @Override
    public Optional<CatMedicamento> getCatMedicamentoByMedicamento(String medicamento) {
        return catMedicamentoService.getCatMedicamentoByMedicamento(medicamento);
    }

    @Override
    public List<CatMedicamento> getAllCatMedicamentos() {
        return catMedicamentoService.getAllCatMedicamentos();
    }
}
