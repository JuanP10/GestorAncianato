package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Dtos.AdultoMayorDto;
import com.example.gestorancianato.Services.AdultoMayorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AdultoMayor")

public class AdultoMayorController {
    private final AdultoMayorService adultoMayorService;

    public AdultoMayorController(AdultoMayorService adultoMayorService) {
        this.adultoMayorService = adultoMayorService;
    }

    @PostMapping()
    public ResponseEntity<AdultoMayorDto> createAdultoMayor(@RequestBody AdultoMayorDto adultoMayor) {
        return ResponseEntity.ok(adultoMayorService.createAdultoMayor(adultoMayor));
    }

    @GetMapping("/all")
    public ResponseEntity<List<AdultoMayorDto>> getAllAdultoMayor() {
        List<AdultoMayorDto> adultoMayorList = adultoMayorService.getAllAdultoMayor();
        return new ResponseEntity<>(adultoMayorList, HttpStatus.OK);
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<AdultoMayorDto> updateAdultoMayor(@PathVariable Integer cedula, @RequestBody AdultoMayorDto adultoMayor) {
        return new ResponseEntity<>(adultoMayorService.updateAdultoMayor(cedula, adultoMayor), HttpStatus.OK);
    }

    @DeleteMapping ("/{cedula}")
    public ResponseEntity<String> deleteAdultoMayor(@PathVariable Integer cedula) {
        adultoMayorService.deleteAdultoMayor(cedula);
        return ResponseEntity.ok().body("Adulto Mayor eliminado");
    }

    @GetMapping ("/{cedula}")
    public ResponseEntity<AdultoMayorDto> getAdultoMayorByCedula(@PathVariable Integer cedula) {
        return new ResponseEntity<>(adultoMayorService.getAdultoMayorByCedula(cedula), HttpStatus.OK);
    }

    @GetMapping ("/nombre&apellido")
    public ResponseEntity<List<AdultoMayorDto>> getAdultoMayorByNombreAndApellido(@RequestParam String nombre, @RequestParam String apellido) {
        return new ResponseEntity<>(adultoMayorService.getAdultoMayorByNombreAndApellido(nombre, apellido), HttpStatus.OK);
    }

    @GetMapping ("/{CondicionMedica}")
    public ResponseEntity<List<AdultoMayorDto>> findByAdultoMayorByCondicionMedica(@PathVariable String CondicionMedica) {
        return new ResponseEntity<>(adultoMayorService.findByAdultoMayorByCondicionMedica(CondicionMedica), HttpStatus.OK);
    }

}
