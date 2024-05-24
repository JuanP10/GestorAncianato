package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Entities.Donante;
import com.example.gestorancianato.Repositories.DonanteRepository;
import com.example.gestorancianato.Services.DonanteService;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DonanteServiceImp implements DonanteService {

    private final DonanteRepository donanteRepository;
    private static final Logger log = LoggerFactory.getLogger(DonanteServiceImp.class);

    @Override
    public Donante createDonante(Donante donante) {
        return donanteRepository.save(donante);
    }

    @Override
    public List<Donante> getAllDonantes() {
        return donanteRepository.findAll();
    }

    @Override
    public Optional<Donante> getDonanteById(Integer cedula) {
        return donanteRepository.findById(cedula);
    }

    @Override
    public Optional<Donante> updateDonante(Integer cedula, Donante donante) {
        Optional<Donante> optionalDonante = donanteRepository.findById(cedula);
        if (optionalDonante.isPresent()) {
            Donante existingDonante = optionalDonante.get();
            existingDonante.setNombre(donante.getNombre());
            existingDonante.setApellido(donante.getApellido());
            existingDonante.setTelefono(donante.getTelefono());
            existingDonante.setDireccion(donante.getDireccion());
            return Optional.of(donanteRepository.save(existingDonante));
        } else {
            log.error("El donante con cédula {} no existe", cedula);
            return Optional.empty();
        }
    }

    @Override
    public void deleteDonante(Integer cedula) {
        donanteRepository.deleteById(cedula);
    }
}
