package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Entities.AdultoMayor;
import com.example.gestorancianato.Repositories.AdultoMayorRepository;
import com.example.gestorancianato.Services.AdultoMayorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AdultoMayorServiceImp implements AdultoMayorService {
    private final AdultoMayorRepository adultoMayorRepository;

    private static final Logger log = LoggerFactory.getLogger(AdultoMayorServiceImp.class);


    public AdultoMayorServiceImp(AdultoMayorRepository adultoMayorRepository) {
        this.adultoMayorRepository = adultoMayorRepository;
    }

    @Override
    public AdultoMayor createAdultoMayor(AdultoMayor adultoMayor) {
        return adultoMayorRepository.save(adultoMayor);
    }

    @Override
    public List<AdultoMayor> getAllAdultoMayor() {
        return adultoMayorRepository.findAll();
    }

    @Override
    public Optional<AdultoMayor> GetAdultoMayorByCedula(Integer cedula) {
        return adultoMayorRepository.findByCedula(cedula);
    }

    @Override
    public Optional<AdultoMayor> updateAdultoMayor(Integer cedula, AdultoMayor adultoMayor) {
        Optional<AdultoMayor> optionalAdultoMayor = adultoMayorRepository.findByCedula(cedula);
        if (optionalAdultoMayor.isPresent()){
            AdultoMayor adultoMayorToUpdate = optionalAdultoMayor.get();
            adultoMayorToUpdate.setNombre(adultoMayorToUpdate.getNombre());
            adultoMayorToUpdate.setApellido(adultoMayorToUpdate.getApellido());
            adultoMayorToUpdate.setFechaNacimiento(adultoMayorToUpdate.getFechaNacimiento());
            adultoMayorToUpdate.setEsPensionado(adultoMayorToUpdate.getEsPensionado());
            return Optional.of(adultoMayorRepository.save(adultoMayorToUpdate));
        } else {
            log.error("El Adulto con cedula {} no existe", cedula);
            return  Optional.empty();

        }
    }

    @Override
    public void deleteAdultoMayor(Integer cedula) {
        adultoMayorRepository.deleteById(cedula);
    }

    @Override
    public List<AdultoMayor> getAdultoMayorByNombreAndApellido(String nombre, String apellido) {
        return adultoMayorRepository.findByNombreOrApellido(nombre, apellido);
    }

    @Override
    public Optional<AdultoMayor> findByAdultoMayorByCondicionMedica(String CondicionMedica) {
        return adultoMayorRepository.getAdultoMayorByCondicionesMedicas(CondicionMedica);
    }
}
