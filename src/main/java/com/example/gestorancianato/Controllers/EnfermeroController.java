package com.example.gestorancianato.Controllers;


import com.example.gestorancianato.Entities.Enfermero;
import com.example.gestorancianato.Services.EnfermeroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Enfermero")

public class EnfermeroController {
    private final EnfermeroService enfermeroService;

    public EnfermeroController(EnfermeroService enfermeroService) {
        this.enfermeroService = enfermeroService;
    }


    @PostMapping("/registrar")
    public Enfermero createEnfermero(@RequestBody Enfermero enfermero) {
        return enfermeroService.createEnfermero(enfermero);
    }

    @GetMapping("/all")
    public List<Enfermero> getAllEnfermeros() {
        return enfermeroService.getAllEnfermeros();
    }

    @GetMapping("/cedula/{cedula}")
    public List<Enfermero> getEnfermeroByCedula(@PathVariable Integer cedula) {
        return enfermeroService.getEnfermeroByCedula(cedula);
    }

    @PutMapping("/update/{cedula}")
    public Optional<Enfermero> updateEnfermero(@PathVariable Integer cedula, @RequestBody Enfermero enfermero) {
        return enfermeroService.updateEnfermero(cedula, enfermero);
    }

    @DeleteMapping("/delete/{cedula}")
    public void deleteEnfermero(@PathVariable Integer cedula) {
        enfermeroService.deleteEnfermero(cedula);
    }

    @GetMapping("/nombre&apellido")
    public List<Enfermero> getEnfermeroByNombreAndApellido(@RequestParam String nombre, @RequestParam String apellido) {
        return enfermeroService.getEnfermeroByNombreAndApellido(nombre, apellido);
    }
}
