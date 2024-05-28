package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Dtos.DonanteDto;
import com.example.gestorancianato.Entities.Donante;
import com.example.gestorancianato.Mappers.DonanteMapper;
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
    private final DonanteMapper donanteMapper;

    public DonanteServiceImp(DonanteRepository donanteRepository, DonanteMapper donanteMapper) {
        this.donanteRepository = donanteRepository;
        this.donanteMapper = donanteMapper;
    }

    @Override
    public DonanteDto createDonante (DonanteDto donante) {
        Donante donanteToSave = donanteMapper.toDonante(donante);
        return donanteMapper.toDonanteDto(donanteRepository.save(donanteToSave));
    }

    @Override
    public List<DonanteDto> getAllDonantes() {
        List<Donante> donantes = donanteRepository.findAll();
        return donantes.stream().map(donanteMapper::toDonanteDto).toList();
    }

    @Override
    public DonanteDto getDonanteByCedula(Integer cedula) {
        Donante donante = donanteRepository.findById(cedula).orElseThrow(() -> new RuntimeException("Donante no encontrado"));
        return donanteMapper.toDonanteDto(donante);
    }

    @Override
    public DonanteDto updateDonante(Integer cedula, DonanteDto donante) {
        Donante donanteToUpdate = donanteMapper.toDonante(donante);
        Donante donanteInDb = donanteRepository.findById(cedula).map(donante1 -> {
            donante1.setNombre(donanteToUpdate.getNombre());
            donante1.setApellido(donanteToUpdate.getApellido());
            donante1.setDireccion(donanteToUpdate.getDireccion());
            donante1.setTelefono(donanteToUpdate.getTelefono());
            return donanteRepository.save(donante1);
        }).orElseThrow(() -> new RuntimeException("Donante no encontrado"));

        return donanteMapper.toDonanteDto(donanteInDb);
    }

    @Override
    public void deleteDonante(Integer cedula) {
        Donante donante = donanteRepository.findById(cedula).orElseThrow(() -> new RuntimeException("Donante no encontrado"));
        donanteRepository.delete(donante);
    }

    @Override
    public List<DonanteDto> getDonantesByNombreAndApellido(String nombre, String apellido) {
        List<Donante> donantes = donanteRepository.findByNombreOrApellido(nombre, apellido);
        return donantes.stream().map(donanteMapper::toDonanteDto).toList();
    }
}
