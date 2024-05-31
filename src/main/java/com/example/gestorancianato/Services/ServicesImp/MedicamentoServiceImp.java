package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Dtos.DonanteDto;
import com.example.gestorancianato.Dtos.MedicamentoDto;
import com.example.gestorancianato.Entities.Donante;
import com.example.gestorancianato.Entities.Medicamento;
import com.example.gestorancianato.Exepciones.DonanteNotFoundException;
import com.example.gestorancianato.Mappers.MedicamentoMapper;
import com.example.gestorancianato.Repositories.DonanteRepository;
import com.example.gestorancianato.Repositories.MedicamentoRepository;
import com.example.gestorancianato.Services.MedicamentoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicamentoServiceImp implements MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;
    private final MedicamentoMapper medicamentoMapper;
    private final DonanteRepository donanteRepository;
    public MedicamentoServiceImp(MedicamentoRepository medicamentoRepository, MedicamentoMapper medicamentoMapper, DonanteRepository donanteRepository) {
        this.medicamentoRepository = medicamentoRepository;
        this.medicamentoMapper = medicamentoMapper;
        this.donanteRepository = donanteRepository;
    }

    @Override
    public MedicamentoDto createMedicamento(MedicamentoDto medicamentoDto) {
        String cedulaDonante = medicamentoDto.getCedulaDonante();
        Optional<Donante> optionalDonante = donanteRepository.findById(Integer.valueOf(cedulaDonante));

        if (optionalDonante.isEmpty()) {
            throw new DonanteNotFoundException("No hay donante con cedula: " + cedulaDonante);
        }

        Donante donante = optionalDonante.get();
        Medicamento medicamento = medicamentoMapper.toMedicamento(medicamentoDto);
        medicamento.setDonante(donante);

        Medicamento savedMedicamento = medicamentoRepository.save(medicamento);
        MedicamentoDto savedMedicamentoDTO = medicamentoMapper.toMedicamentoDto(savedMedicamento);

        // Set the full Donante details in the response DTO
        savedMedicamentoDTO.setCedulaDonante(String.valueOf(donante.getCedula()));

        return savedMedicamentoDTO;
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
        return medicamentoRepository.findAll()
                .stream()
                .map(medicamentoMapper::toMedicamentoDto)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<MedicamentoDto> updateMedicamento(Integer id, Medicamento medicamento) {
        Optional<Medicamento> medicamentoOptional = medicamentoRepository.findById(id);
        if(medicamentoOptional != null){
            Medicamento updatedMedicamento = medicamentoOptional.get().updateMedicamento(medicamento);
            medicamentoRepository.save(updatedMedicamento);
            return Optional.of(medicamentoMapper.toMedicamentoDto(updatedMedicamento));
        }else{
            MedicamentoDto medicamentoDto = medicamentoMapper.toMedicamentoDto(medicamentoRepository.save(medicamento));
            return Optional.ofNullable(medicamentoDto) ;
        }
    }

    @Override
    public void deleteMedicamentoById(Integer id) {
        Medicamento medicamento = medicamentoRepository.findById(id).orElseThrow(()->
                new RuntimeException("Medicamento no encontrado"));
        medicamentoRepository.delete(medicamento);
    }


}

