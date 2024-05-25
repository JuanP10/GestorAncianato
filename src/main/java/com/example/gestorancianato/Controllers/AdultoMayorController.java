package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Entities.AdultoMayor;
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

    @PostMapping("/register")
    public ResponseEntity<AdultoMayor> createAdultoMayor(@RequestBody AdultoMayor adultoMayor) {
        return ResponseEntity.ok(adultoMayorService.createAdultoMayor(adultoMayor));
    }

    @GetMapping("/all")
    public List<AdultoMayor> getAllAdultoMayor() {
        return adultoMayorService.getAllAdultoMayor();
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<AdultoMayor> updateAdultoMayor(@PathVariable Integer cedula, @RequestBody AdultoMayor adultoMayor) {
        return new ResponseEntity<>(adultoMayorService.updateAdultoMayor(cedula, adultoMayor).orElse(null), HttpStatus.OK);
    }

    @DeleteMapping ("/{cedula}")
    public ResponseEntity<Void> deleteAdultoMayor(@PathVariable Integer cedula) {
        adultoMayorService.deleteAdultoMayor(cedula);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping ("/{cedula}")
    public ResponseEntity<AdultoMayor> getAdultoMayorByCedula(@PathVariable Integer cedula) {
        return new ResponseEntity<>(adultoMayorService.GetAdultoMayorByCedula(cedula).orElse(null), HttpStatus.OK);
    }

    @GetMapping ("/nombre&apellido")
    public ResponseEntity<List<AdultoMayor>> getAdultoMayorByNombreAndApellido(@RequestParam String nombre, @RequestParam String apellido) {
        return new ResponseEntity<>(adultoMayorService.getAdultoMayorByNombreAndApellido(nombre, apellido), HttpStatus.OK);
    }

    @GetMapping ("/{condicionMedica}")
    public List<AdultoMayor> findByAdultoMayorByCondicionMedica(@PathVariable String CondicionMedica) {
        return adultoMayorService.findByAdultoMayorByCondicionMedica(CondicionMedica);
    }

}
