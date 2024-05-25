package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Entities.Donante;
import com.example.gestorancianato.Repositories.DonanteRepository;
import com.example.gestorancianato.Services.DonanteService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import java.util.List;
import java.util.Optional;

@Service
public class DonanteServiceImp  implements DonanteService{

    private final  DonanteRepository donanteRepository;
    private static final Logger log = LoggerFactory.getLogger(DonanteServiceImp.class);


    public DonanteServiceImp(DonanteRepository donanteRepository) {
        this.donanteRepository = donanteRepository;
    }

    @Override
    public Donante createDonante(Donante donante) {
        return donanteRepository.save(donante);
    }

    @Override
    public List<Donante> getAllDonantes() {
        return donanteRepository.findAll();
    }

    @Override
    public Optional<Donante> getDonanteByCedula(Integer cedula) {
        return donanteRepository.findByCedula(cedula);
    }

    @Override
    public Optional<Donante> updateDonante(Integer cedula, Donante donante) {
        Optional<Donante> optionalDonante = donanteRepository.findById(cedula);
        if (optionalDonante.isPresent()) {
            Donante donanteToUpdate = optionalDonante.get();
            donanteToUpdate.setNombre(donante.getNombre());
            donanteToUpdate.setApellido(donante.getApellido());
            donanteToUpdate.setTelefono(donante.getTelefono());
            donanteToUpdate.setDireccion(donante.getDireccion());
            return Optional.of(donanteRepository.save(donanteToUpdate));
        } else {
            log.error("El Donante con cedula {} no existe", cedula);
            return Optional.empty();
        }
    }

    @Override
    public void deleteDonante(Integer cedula) {
        donanteRepository.deleteById(cedula);
    }

    @Override
    public List<Donante> getDonantesByNombreAndApellido(String nombre, String apellido) {
        return donanteRepository.findByNombreOrApellido(nombre, apellido);
    }
}
