package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Dtos.DonanteDto;
import com.example.gestorancianato.Entities.Donante;
import com.example.gestorancianato.Mappers.DonanteMapper;
import com.example.gestorancianato.Repositories.DonanteRepository;
import com.example.gestorancianato.Services.DonanteService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DonanteServiceImp  implements DonanteService{

    private final  DonanteRepository donanteRepository;
    private final DonanteMapper donanteMapper;

    private static final Logger log = LoggerFactory.getLogger(DonanteServiceImp.class);

    @Override
    public DonanteDto createDonante (DonanteDto donante) {
        Donante donanteToSave = donanteMapper.toDonante(donante);
        return donanteMapper.toDonanteDto(donanteRepository.save(donanteToSave));
    }

    @Override
    public List<DonanteDto> getAllDonantes() {
        List<Donante> donantes = donanteRepository.findAll();
        return donantes.stream().map(donanteMapper::toDonanteDto).collect(Collectors.toList());
    }

    @Override
    public Optional<DonanteDto> getDonanteByCedula(Long cedula) {
        Optional<Donante> donante = donanteRepository.findById(cedula);
        if (donante.isPresent())
            return donante.map(donanteMapper::toDonanteDto);
        throw new RuntimeException("Donante con la cedula " + cedula + " no encontrado");
    }


    @Override
    public DonanteDto updateDonante(Long cedula, DonanteDto donante) {
        Optional<Donante> donanteOptional = donanteRepository.findById(cedula);
        if (donanteOptional != null){
            Donante updatedDonante = donanteMapper.toDonante(donante);
            donanteRepository.save(updatedDonante);
            return donanteMapper.toDonanteDto(updatedDonante);
        }else{
            DonanteDto donanteDto = createDonante(donante);
            return donanteDto;
        }
    }

    @Override
    public ResponseEntity<String> deleteDonante(Long cedula) {
       try {
              donanteRepository.deleteById(cedula);
              log.info("El donante con cedula {} ha sido eliminado", cedula);
                return ResponseEntity.ok("Donante eliminado");
       } catch (EmptyResultDataAccessException e){
           log.warn("El donante con cedula {} no existe", cedula);
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El donante con cedula " + cedula + " no existe");
       } catch (Exception e){
           log.error("Error al eliminar el donante con cedula {}", cedula, e);
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el donante con cedula " + cedula);
       }

    }

    @Override
    public Optional<DonanteDto> getDonantesByNombreAndApellido(String nombre, String apellido) {
        Optional<Donante> donante = donanteRepository.findByNombreOrApellido(nombre, apellido);
        if(donante.isEmpty())
            throw new RuntimeException("Donante con nombre " + nombre + " y apellido " + apellido + " no encontrado");
        return donante.map(donanteMapper::toDonanteDto);
    }
}
