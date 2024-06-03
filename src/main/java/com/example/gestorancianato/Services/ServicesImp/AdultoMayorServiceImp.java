package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Dtos.AdultoMayorDto;
import com.example.gestorancianato.Entities.AdultoMayor;
import com.example.gestorancianato.Entities.CondicionMedica;
import com.example.gestorancianato.Exepciones.CategoriaMedicamentoNotFoundException;
import com.example.gestorancianato.Exepciones.DonanteNotFoundException;
import com.example.gestorancianato.Mappers.AdultoMayorMapper;
import com.example.gestorancianato.Repositories.AdultoMayorRepository;
import com.example.gestorancianato.Repositories.CondicionMedicaRepository;
import com.example.gestorancianato.Services.AdultoMayorService;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdultoMayorServiceImp implements AdultoMayorService {
    private final AdultoMayorRepository adultoMayorRepository;
    private final AdultoMayorMapper adultoMayorMapper;

    private final CondicionMedicaRepository condicionMedicaRepository;

    public AdultoMayorServiceImp(AdultoMayorRepository adultoMayorRepository, AdultoMayorMapper adultoMayorMapper, CondicionMedicaRepository condicionMedicaRepository) {
        this.adultoMayorRepository = adultoMayorRepository;
        this.adultoMayorMapper = adultoMayorMapper;
        this.condicionMedicaRepository = condicionMedicaRepository;
    }

    @Override
    public AdultoMayorDto createAdultoMayor(AdultoMayorDto adultoMayorDto) {
        Set<CondicionMedica> condicionMedicas = new HashSet<>();
        for (Long condiciones : adultoMayorDto.getIdsCondicion()){
            CondicionMedica condicion = condicionMedicaRepository.findById(condiciones).
                    orElseThrow(() -> new CategoriaMedicamentoNotFoundException("Condicion Medica no registradada con el id: " + condiciones));
            condicionMedicas.add(condicion);
        }

        AdultoMayor adultoMayor = adultoMayorMapper.toAdultoMayor(adultoMayorDto);
        adultoMayor.setCondicionesMedicas(condicionMedicas);

        AdultoMayor savedAdultoMayor = adultoMayorRepository.save(adultoMayor);
        return adultoMayorMapper.toAdultoMayorDto(savedAdultoMayor);
    }

    @Override
    public List<AdultoMayorDto> getAllAdultoMayor() {
        List<AdultoMayor> adultoMayorList = adultoMayorRepository.findAll();
        return adultoMayorList.stream().map(adultoMayorMapper::toAdultoMayorDto).toList();
    }

    @Override
    public AdultoMayorDto getAdultoMayorByCedula(Long cedula) {
        AdultoMayor adultoMayor = adultoMayorRepository.findByCedula(cedula)
                .orElseThrow(() -> new EntityNotFoundException("Adulto Mayor no encontrado con cedula: " + cedula));
        return adultoMayorMapper.toAdultoMayorDto(adultoMayor);
    }

    @Override
    public AdultoMayorDto updateAdultoMayor(Long cedula, AdultoMayorDto adultoMayorDto) {
        AdultoMayor adultoMayor = adultoMayorRepository.findByCedula(cedula)
                .orElseThrow(() ->new ResponseStatusException(HttpStatus.NOT_FOUND, "Adulto Mayor no encontrado con la cedula: " + cedula));

        Set<CondicionMedica> condicionMedicas = new HashSet<>();
        for (Long condiciones : adultoMayorDto.getIdsCondicion()){
            CondicionMedica condicion = condicionMedicaRepository.findById(condiciones)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Condicion Medica no registrada con el id: " + condiciones));
            condicionMedicas.add(condicion);
        }

        adultoMayor.setNombre(adultoMayor.getNombre());
        adultoMayor.setApellido(adultoMayor.getApellido());
        adultoMayor.setFechaNacimiento(adultoMayor.getFechaNacimiento());
        adultoMayor.setEsPensionado(adultoMayor.getEsPensionado());
        adultoMayor.setCondicionesMedicas(condicionMedicas);

        AdultoMayor updateAdultoMayor = adultoMayorRepository.save(adultoMayor);

        return adultoMayorMapper.toAdultoMayorDto(updateAdultoMayor);

    }

    @Override
    public void deleteAdultoMayor(Long cedula) {
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
