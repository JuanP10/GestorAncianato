package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Dtos.DonanteDto;
import com.example.gestorancianato.Entities.Donante;
import com.example.gestorancianato.Services.DonanteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/Donante")
public class DonanteController {

    private final DonanteService donanteService;
    @PostMapping
    public ResponseEntity<DonanteDto> registrarDonante(@RequestBody @Validated DonanteDto donante){
        DonanteDto donanteDtoGuardar = donanteService.createDonante(donante);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{cedula}")
                .buildAndExpand(donanteDtoGuardar.getCedula())
                .toUri();
        return ResponseEntity.created(location).body(donanteDtoGuardar);
    }

    @PutMapping ("/{cedula}")
    public ResponseEntity<DonanteDto> updateDonante(@PathVariable Long cedula, @RequestBody DonanteDto donante){
        Optional<DonanteDto> updatedDonante = Optional.ofNullable(donanteService.updateDonante(cedula, donante));
        if (updatedDonante.isPresent()) {
            return new ResponseEntity<>(updatedDonante.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/{cedula}")
    public ResponseEntity<Donante> deleteDonante(@PathVariable Long cedula){
        donanteService.deleteDonante(cedula);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<DonanteDto> getDonanteByCedula(@PathVariable Long cedula){
        Optional<DonanteDto> donanteDto = donanteService.getDonanteByCedula(cedula);
        if(donanteDto.isPresent())
            return new ResponseEntity<>(donanteDto.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/nombre&apellido")
    public ResponseEntity<?> getDonantesByNombreAndApellido(@RequestParam String nombre, @RequestParam String apellido){
        Optional <DonanteDto> donanteDto = donanteService.getDonantesByNombreAndApellido(nombre, apellido);
        if (donanteDto.isPresent())
            return new ResponseEntity<>(donanteDto.get(), HttpStatus.OK);

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<DonanteDto>> getAllDonantes(){
        return new ResponseEntity<>(donanteService.getAllDonantes(), HttpStatus.OK);
    }

}
