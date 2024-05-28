package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Dtos.AdultoMayorDto;
import com.example.gestorancianato.Entities.AdultoMayor;
import com.example.gestorancianato.Mappers.AdultoMayorMapper;
import com.example.gestorancianato.Repositories.AdultoMayorRepository;
import com.example.gestorancianato.Services.AdultoMayorService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdultoMayorServiceImp implements AdultoMayorService {
    private final AdultoMayorRepository adultoMayorRepository;
    private final AdultoMayorMapper adultoMayorMapper;

    public AdultoMayorServiceImp(AdultoMayorRepository adultoMayorRepository, AdultoMayorMapper adultoMayorMapper) {
        this.adultoMayorRepository = adultoMayorRepository;
        this.adultoMayorMapper = adultoMayorMapper;
    }

    @Override
    public AdultoMayorDto createAdultoMayor(AdultoMayorDto adultoMayorDto) {
        AdultoMayor adultoMayor = adultoMayorMapper.toAdultoMayor(adultoMayorDto);
        return adultoMayorMapper.toAdultoMayorDto(adultoMayorRepository.save(adultoMayor));
    }

    @Override
    public List<AdultoMayorDto> getAllAdultoMayor() {
        List<AdultoMayor> adultoMayorList = adultoMayorRepository.findAll();
        return adultoMayorList.stream().map(adultoMayorMapper::toAdultoMayorDto).toList();
    }

    @Override
    public AdultoMayorDto getAdultoMayorByCedula(Integer cedula) {
        AdultoMayor adultoMayor = adultoMayorRepository.findByCedula(cedula)
                .orElseThrow(() -> new EntityNotFoundException("Adulto Mayor no encontrado con cedula: " + cedula));
        return adultoMayorMapper.toAdultoMayorDto(adultoMayor);
    }

    @Override
    public AdultoMayorDto updateAdultoMayor(Integer cedula, AdultoMayorDto adultoMayorDto) {
        AdultoMayor adultoMayorEntity = adultoMayorMapper.toAdultoMayor(adultoMayorDto);
        AdultoMayor adultoMayorActualizado = adultoMayorRepository.findByCedula(cedula).map(adultoMayorEncontrado -> {
            adultoMayorEncontrado.setNombre(adultoMayorEntity.getNombre());
            adultoMayorEncontrado.setApellido(adultoMayorEntity.getApellido());
            adultoMayorEncontrado.setFechaNacimiento(adultoMayorEntity.getFechaNacimiento());
            adultoMayorEncontrado.setEsPensionado(adultoMayorEntity.getEsPensionado());
            return adultoMayorRepository.save(adultoMayorEncontrado);
        }).orElseThrow(() -> new EntityNotFoundException("Adulto Mayor no encontrado"));
        return adultoMayorMapper.toAdultoMayorDto(adultoMayorActualizado);
    }

    @Override
    public void deleteAdultoMayor(Integer cedula) {
        AdultoMayor adultoMayor = adultoMayorRepository.findByCedula(cedula)
                .orElseThrow(() -> new EntityNotFoundException("Adulto Mayor no encontrado"));
        adultoMayorRepository.delete(adultoMayor);
    }

    @Override
    public List<AdultoMayorDto> getAdultoMayorByNombreAndApellido(String nombre, String apellido) {
        List<AdultoMayor> adultoMayorList = adultoMayorRepository.findByNombreOrApellido(nombre, apellido);
        return adultoMayorList.stream().map(adultoMayorMapper::toAdultoMayorDto).toList();
    }

    @Override
    public List<AdultoMayorDto> findByAdultoMayorByCondicionMedica(String condicionMedica) {
        List<AdultoMayor> adultoMayorList = adultoMayorRepository.findAdultosMayoresByCondicionMedica(condicionMedica);
        return adultoMayorList.stream().map(adultoMayorMapper::toAdultoMayorDto).toList();
    }
}
