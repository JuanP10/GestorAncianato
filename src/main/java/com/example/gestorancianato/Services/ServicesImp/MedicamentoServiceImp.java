package com.example.gestorancianato.Services.ServicesImp;


import com.example.gestorancianato.Dtos.MedicamentoDto;
import com.example.gestorancianato.Entities.CategoriaMedicamento;
import com.example.gestorancianato.Entities.Donante;
import com.example.gestorancianato.Entities.Medicamento;

import com.example.gestorancianato.Exepciones.CategoriaMedicamentoNotFoundException;
import com.example.gestorancianato.Exepciones.DonanteNotFoundException;
import com.example.gestorancianato.Mappers.CategoriaMedicamentoMapper;
import com.example.gestorancianato.Mappers.MedicamentoMapper;
import com.example.gestorancianato.Repositories.CategoriaMedicamentoRepository;
import com.example.gestorancianato.Repositories.DonanteRepository;
import com.example.gestorancianato.Repositories.MedicamentoRepository;
import com.example.gestorancianato.Services.MedicamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MedicamentoServiceImp implements MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;
    private final MedicamentoMapper medicamentoMapper;
    private final DonanteRepository donanteRepository;
    private final CategoriaMedicamentoRepository categoriaMedicamentoRepository;
    private  final CategoriaMedicamentoMapper categoriaMedicamentoMapper;
    public MedicamentoServiceImp(MedicamentoRepository medicamentoRepository, MedicamentoMapper medicamentoMapper, DonanteRepository donanteRepository, CategoriaMedicamentoRepository categoriaMedicamentoRepository, CategoriaMedicamentoMapper categoriaMedicamentoMapper) {
        this.medicamentoRepository = medicamentoRepository;
        this.medicamentoMapper = medicamentoMapper;
        this.donanteRepository = donanteRepository;
        this.categoriaMedicamentoRepository = categoriaMedicamentoRepository;
        this.categoriaMedicamentoMapper = categoriaMedicamentoMapper;
    }
    @Override
    public MedicamentoDto createMedicamento(MedicamentoDto medicamentoDto) {
        // Verificar que el Donante existe
        Donante donante = donanteRepository.findByCedula(medicamentoDto.getCedulaDonante())
                .orElseThrow(() -> new DonanteNotFoundException("Donante no registrado con la cedula: " + medicamentoDto.getCedulaDonante()));

        // Verificar que las Categorias existen
        Set<CategoriaMedicamento> categorias = new HashSet<>();
        for (Long categoriaId : medicamentoDto.getIdsCategorias()) {
            CategoriaMedicamento categoria = categoriaMedicamentoRepository.findById(categoriaId)
                    .orElseThrow(() -> new CategoriaMedicamentoNotFoundException("Categoría Medicamento no registrada: " + categoriaId));
            categorias.add(categoria);
        }

        // Convertir DTO a entidad y asignar donante y categorías
        Medicamento medicamento = medicamentoMapper.toMedicamento(medicamentoDto);
        medicamento.setDonante(donante);
        medicamento.setCategoriaMedicamento(categorias);

        Medicamento savedMedicamento = medicamentoRepository.save(medicamento);

        return medicamentoMapper.toMedicamentoDto(savedMedicamento);
    }




    @Override
    public MedicamentoDto getMedicamentoById(Long id) {
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
    public List<MedicamentoDto> getMedicamentoByDonanteCedula(Long cedula) {
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
    public MedicamentoDto updateMedicamento(Long id, MedicamentoDto medicamentoDto) {
        // Verificar que el Medicamento existe
        Medicamento medicamento = medicamentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Medicamento no encontrado"));

        // Verificar que el Donante existe
        Donante donante = donanteRepository.findByCedula(medicamentoDto.getCedulaDonante())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Donante no registrado"));

        // Verificar que las Categorias existen
        Set<CategoriaMedicamento> categorias = new HashSet<>();
        for (Long categoriaId : medicamentoDto.getIdsCategorias()) {
            CategoriaMedicamento categoria = categoriaMedicamentoRepository.findById(categoriaId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoría Medicamento no registrada: " + categoriaId));
            categorias.add(categoria);
        }

        // Actualizar los datos del Medicamento
        medicamento.setNombre(medicamentoDto.getNombre());
        medicamento.setDonante(donante);
        medicamento.setCategoriaMedicamento(categorias);

        // Guardar los cambios
        Medicamento updatedMedicamento = medicamentoRepository.save(medicamento);

        return medicamentoMapper.toMedicamentoDto(updatedMedicamento);
    }

    @Override
    public void deleteMedicamentoById(Long id) {
        Medicamento medicamento = medicamentoRepository.findById(id).orElseThrow(()->
                new RuntimeException("Medicamento no encontrado"));
        medicamentoRepository.delete(medicamento);
    }


}

/*
@Override
    public MedicamentoDto createMedicamento(MedicamentoDto medicamentoDto) throws CategoriaMedicamentoNotFoundException, DonanteNotFoundException {

        // Convertir la lista de IDs de categorías de medicamentos a una cadena separada por comas
        String idCategoriaMedicamentoAsString = String.join(",", medicamentoDto.getIdCategoriaMedicamento());

        // Verificar si la categoría de medicamento existe en la base de datos
        Optional<CategoriaMedicamento> optionalCategoria = categoriaMedicamentoRepository.findById(Integer.valueOf(idCategoriaMedicamentoAsString));

        switch (validateCategoriaMedicamento(optionalCategoria)) {
            case NO_CATEGORIA:
                throw new CategoriaMedicamentoNotFoundException("La categoría de medicamento es requerida para crear el medicamento.");
            case CATEGORIA_NO_EXISTE:
                throw new CategoriaMedicamentoNotFoundException("No existe la categoría de medicamento: " + idCategoriaMedicamentoAsString);
            case CATEGORIA_VALIDA:
                break; // La categoría es válida, continuar
        }

        String cedulaDonante = medicamentoDto.getCedulaDonante();
        Optional<Donante> optionalDonante = donanteRepository.findById(Integer.valueOf(cedulaDonante));

        switch (validateDonante(optionalDonante)) {
            case NO_DONANTE:
                throw new DonanteNotFoundException("No hay donante con cédula: " + cedulaDonante);
            case DONANTE_VALIDO:
                break; // El donante es válido, continuar
        }

        Donante donante = optionalDonante.get();
        Medicamento medicamento = medicamentoMapper.toMedicamento(medicamentoDto);
        medicamento.setDonante(donante);

        // Asociar la categoría de medicamento al medicamento
        CategoriaMedicamento categoriaMedicamento = optionalCategoria.get();
        medicamento.setCategoriaMedicamento((List<CategoriaMedicamento>) categoriaMedicamento);

        // Guardar el medicamento en la base de datos
        Medicamento savedMedicamento = medicamentoRepository.save(medicamento);
        MedicamentoDto savedMedicamentoDTO = medicamentoMapper.toMedicamentoDto(savedMedicamento);

        // Set the full details of the associated CategoriaMedicamento in the response DTO
        savedMedicamentoDTO.setCategoriaMedicamento((List<CategoriaMedicamentoDto>) categoriaMedicamentoMapper.toCategoriaMedicamentoDto(categoriaMedicamento));

        // Set the full Donante details in the response DTO
        savedMedicamentoDTO.setCedulaDonante(String.valueOf(donante.getCedula()));

        return savedMedicamentoDTO;
    }



    private enum CategoriaMedicamentoValidationResult {
        NO_CATEGORIA,
        CATEGORIA_NO_EXISTE,
        CATEGORIA_VALIDA
    }

    private CategoriaMedicamentoValidationResult validateCategoriaMedicamento(Optional<CategoriaMedicamento> optionalCategoriaMedicamento) {
        return optionalCategoriaMedicamento.isEmpty() ? CategoriaMedicamentoValidationResult.NO_CATEGORIA : CategoriaMedicamentoValidationResult.CATEGORIA_VALIDA;
    }

    private enum DonanteValidationResult {
        NO_DONANTE,
        DONANTE_VALIDO
    }

    private DonanteValidationResult validateDonante(Optional<Donante> optionalDonante) {
        return optionalDonante.isEmpty() ? DonanteValidationResult.NO_DONANTE : DonanteValidationResult.DONANTE_VALIDO;
    }
 */
