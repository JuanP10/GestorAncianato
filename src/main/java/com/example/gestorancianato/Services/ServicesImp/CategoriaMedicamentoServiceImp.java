package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Dtos.CategoriaMedicamentoDto;
import com.example.gestorancianato.Entities.CategoriaMedicamento;
import com.example.gestorancianato.Mappers.CategoriaMedicamentoMapper;
import com.example.gestorancianato.Repositories.CategoriaMedicamentoRepository;
import com.example.gestorancianato.Services.CategoriaMedicamentoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaMedicamentoServiceImp implements CategoriaMedicamentoService {

    private final CategoriaMedicamentoRepository categoriaMedicamentoRepository;
    private final CategoriaMedicamentoMapper categoriaMedicamentoMapper;

    public CategoriaMedicamentoServiceImp(CategoriaMedicamentoRepository categoriaMedicamentoRepository, CategoriaMedicamentoMapper categoriaMedicamentoMapper) {
        this.categoriaMedicamentoRepository = categoriaMedicamentoRepository;
        this.categoriaMedicamentoMapper = categoriaMedicamentoMapper;
    }

    @Override
    public CategoriaMedicamentoDto getCategoriaById(Long id) {
        CategoriaMedicamento categoriaMedicamento = categoriaMedicamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada con el id: " + id));
        return categoriaMedicamentoMapper.toCategoriaMedicamentoDto(categoriaMedicamento);
    }

    @Override
    public CategoriaMedicamentoDto createCategoria(CategoriaMedicamentoDto categoriaMedicamento) {
        CategoriaMedicamento categoriaMedicamentoEntity = categoriaMedicamentoMapper.toCategoriaMedicamento(categoriaMedicamento);
        return categoriaMedicamentoMapper.toCategoriaMedicamentoDto(categoriaMedicamentoRepository.save(categoriaMedicamentoEntity));
    }

    @Override
    public CategoriaMedicamentoDto updateCategoria(Long id, CategoriaMedicamentoDto categoriaMedicamento) {
        CategoriaMedicamento categoriaMedicamentoEntity = categoriaMedicamentoMapper.toCategoriaMedicamento(categoriaMedicamento);
        CategoriaMedicamento categoriaMedicamentoToUpdate = categoriaMedicamentoRepository.findById(id).map(categoriaMedicamentoEntity1 -> {
            categoriaMedicamentoEntity1.setNombreCat(categoriaMedicamentoEntity.getNombreCat());
            return categoriaMedicamentoRepository.save(categoriaMedicamentoEntity1);
        }).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        return categoriaMedicamentoMapper.toCategoriaMedicamentoDto(categoriaMedicamentoToUpdate);
    }

    @Override
    public void deleteCategoriaById (Long id) {
        CategoriaMedicamento categoriaMedicamento = categoriaMedicamentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
        categoriaMedicamentoRepository.delete(categoriaMedicamento);

    }

    @Override
    public List<CategoriaMedicamentoDto> getAllCategorias() {
        List<CategoriaMedicamento> categoriaMedicamentos = categoriaMedicamentoRepository.findAll();
        return categoriaMedicamentos.stream().map(categoriaMedicamentoMapper::toCategoriaMedicamentoDto).toList();
    }

}
