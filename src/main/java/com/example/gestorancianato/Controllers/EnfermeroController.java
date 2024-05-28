package com.example.gestorancianato.Controllers;


import com.example.gestorancianato.Dtos.EnfermeroDto;
import com.example.gestorancianato.Services.EnfermeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Enfermero")

public class EnfermeroController {
    private final EnfermeroService enfermeroService;

    public EnfermeroController(EnfermeroService enfermeroService) {
        this.enfermeroService = enfermeroService;
    }


    @PostMapping
    public ResponseEntity<EnfermeroDto> createEnfermero(@RequestBody EnfermeroDto enfermero) {
        EnfermeroDto enfermeroDto = enfermeroService.createEnfermero(enfermero);
        return new ResponseEntity<>(enfermeroDto, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<EnfermeroDto>> getAllEnfermeros() {
        List<EnfermeroDto> enfermeros = enfermeroService.getAllEnfermeros();
        return new ResponseEntity<>(enfermeros, HttpStatus.OK);
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<List<EnfermeroDto>> getEnfermeroByCedula(@PathVariable Integer cedula) {
        List<EnfermeroDto> enfermeros = enfermeroService.getEnfermeroByCedula(cedula);
        return new ResponseEntity<>(enfermeros, HttpStatus.OK);
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<EnfermeroDto> updateEnfermero(@PathVariable Integer cedula, @RequestBody EnfermeroDto enfermero) {
        EnfermeroDto enfermeroDto = enfermeroService.updateEnfermero(cedula, enfermero);
        return new ResponseEntity<>(enfermeroDto, HttpStatus.OK);
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<String> deleteEnfermero(@PathVariable Integer cedula) {
        enfermeroService.deleteEnfermero(cedula);
        return new ResponseEntity<>("Enfermero eliminado", HttpStatus.OK);
    }

    @GetMapping("/nombre&apellido")
    public ResponseEntity<List<EnfermeroDto>> getEnfermeroByNombreAndApellido(@RequestParam String nombre, @RequestParam String apellido) {
        List<EnfermeroDto> enfermeros = enfermeroService.getEnfermeroByNombreAndApellido(nombre, apellido);
        return new ResponseEntity<>(enfermeros, HttpStatus.OK);
    }
}
