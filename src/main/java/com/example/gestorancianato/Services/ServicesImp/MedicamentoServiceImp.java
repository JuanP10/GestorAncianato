package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Dtos.MedicamentoDto;
import com.example.gestorancianato.Entities.Medicamento;
import com.example.gestorancianato.Mappers.MedicamentoMapper;
import com.example.gestorancianato.Repositories.MedicamentoRepository;
import com.example.gestorancianato.Services.MedicamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoServiceImp implements MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;
    private final MedicamentoMapper medicamentoMapper;
    public MedicamentoServiceImp(MedicamentoRepository medicamentoRepository, MedicamentoMapper medicamentoMapper) {
        this.medicamentoRepository = medicamentoRepository;
        this.medicamentoMapper = medicamentoMapper;
    }

    @Override
    public MedicamentoDto createMedicamento(MedicamentoDto medicamento) {
        Medicamento medicamentoToCreate = medicamentoMapper.toMedicamento(medicamento);
        return medicamentoMapper.toMedicamentoDto(medicamentoRepository.save(medicamentoToCreate));
    }

    @Override
    public MedicamentoDto getMedicamentoById(Integer id) {
        Medicamento medicamento = medicamentoRepository.findById(id).orElseThrow(()->
                new RuntimeException("Medicamento no encontrado"));
        return medicamentoMapper.toMedicamentoDto(medicamento);
    }

    @Override
    public List<MedicamentoDto> getMedicamentosByCatMedicamentos(String categoria) {
        List<Medicamento> medicamentos = medicamentoRepository.findByCatMedicamentos(categoria);
        return medicamentos.stream().map(medicamentoMapper::toMedicamentoDto).toList();
    }

    @Override
    public List<MedicamentoDto> getMedicamentoByDonanteCedula(Integer cedula) {
        List<Medicamento> medicamentos = medicamentoRepository.findByDonanteCedula(cedula);
        return medicamentos.stream().map(medicamentoMapper::toMedicamentoDto).toList();
    }

    @Override
    public List<MedicamentoDto> getMedicamentoByFechaVencimientoMesAndAño(int mes, int año) {
        List<Medicamento> medicamentos = medicamentoRepository.findByFechaVencimientoMesAndAño(mes, año);
        return medicamentos.stream().map(medicamentoMapper::toMedicamentoDto).toList();
    }

    @Override
    public List<MedicamentoDto> getAllMedicamentos() {
        List<Medicamento> medicamentos = medicamentoRepository.findAll();
        return medicamentos.stream().map(medicamentoMapper::toMedicamentoDto).toList();
    }

    @Override
    public MedicamentoDto updateMedicamento(Integer id, MedicamentoDto medicamento) {
        Medicamento medicamentoEntity = medicamentoMapper.toMedicamento(medicamento);
        Medicamento medicamentoToUpdate = medicamentoRepository.findById(id).map(medicamentoEncontrado -> {
            medicamentoEncontrado.setNombre(medicamentoEntity.getNombre());
            medicamentoEncontrado.setFechaVencimiento(medicamentoEntity.getFechaVencimiento());
            medicamentoEncontrado.setCantidad(medicamentoEntity.getCantidad());
            return medicamentoRepository.save(medicamentoEncontrado);
        }).orElseThrow(() -> new RuntimeException("Medicamento no encontrado"));
        return medicamentoMapper.toMedicamentoDto(medicamentoToUpdate);
    }

    @Override
    public void deleteMedicamentoById(Integer id) {
        Medicamento medicamento = medicamentoRepository.findById(id).orElseThrow(()->
                new RuntimeException("Medicamento no encontrado"));
        medicamentoRepository.delete(medicamento);
    }


}

