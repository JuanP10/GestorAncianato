package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Entities.Medicamento;
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
    private static final Logger log = LoggerFactory.getLogger(MedicamentoServiceImp.class);

    public MedicamentoServiceImp(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    @Override
    public Medicamento createMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    @Override
    public Optional<Medicamento> getMedicamentoById(Integer id) {
        return medicamentoRepository.findById(id);
    }

    @Override
    public List<Medicamento> getMedicamentosByCatMedicamentos(String categoria) {
        return medicamentoRepository.findByCatMedicamentos(categoria);
    }

    @Override
    public List<Medicamento> getMedicamentoByDonanteCedula(Integer cedula) {
        return medicamentoRepository.findByDonanteCedula(cedula);
    }

    @Override
    public List<Medicamento> getMedicamentoByFechaVencimientoMesAndAño(int mes, int año) {
        return medicamentoRepository.findByFechaVencimientoMesAndAño(mes, año);
    }

    @Override
    public List<Medicamento> getAllMedicamentos() {
        return medicamentoRepository.findAll();
    }

    @Override
    public Optional<Medicamento> updateMedicamento(Integer id, Medicamento medicamento) {
        Optional<Medicamento> optionalMedicamento = medicamentoRepository.findById(id);
        if (optionalMedicamento.isPresent()) {
            Medicamento medicamentoToUpdate = optionalMedicamento.get();
            medicamentoToUpdate.setNombre(medicamento.getNombre());
            medicamentoToUpdate.setCantidad(medicamento.getCantidad());
            medicamentoToUpdate.setCatMedicamentos(medicamento.getCatMedicamentos());
            medicamentoToUpdate.setSuministros(medicamento.getSuministros());
            medicamentoToUpdate.setFechaVencimiento(medicamento.getFechaVencimiento());
            medicamentoToUpdate.setDonante(medicamento.getDonante());
            return Optional.of(medicamentoRepository.save(medicamentoToUpdate));
        } else {
            log.error("El Medicamento con id {} no existe", id);
            return Optional.empty();
        }
    }

    @Override
    public void deleteMedicamentoById(Integer id) {
        medicamentoRepository.deleteById(id);
    }


}

