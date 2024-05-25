package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Entities.Donante;
import com.example.gestorancianato.Services.DonanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Donante")
public class DonanteController {

    private final DonanteService donanteService;
    public DonanteController(DonanteService donanteService) {
        this.donanteService = donanteService;
    }

    @PostMapping("/Registrar")
    public ResponseEntity<Donante> registrarDonante(@RequestBody Donante donante){
        return new ResponseEntity<>(donanteService.createDonante(donante), HttpStatus.CREATED);
    }

    @PostMapping ("/{cedula}")
    public ResponseEntity<Donante> updateDonante(@PathVariable Integer cedula, @RequestBody Donante donante){
        return new ResponseEntity<>(donanteService.updateDonante(cedula, donante).orElse(null), HttpStatus.OK);
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> deleteDonante(@PathVariable Integer cedula){
        donanteService.deleteDonante(cedula);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<Donante> getDonanteByCedula(@PathVariable Integer cedula){
        return new ResponseEntity<>(donanteService.getDonanteByCedula(cedula).orElse(null), HttpStatus.OK);
    }

    @GetMapping("/nombre&apellido")
    public List<Donante> getDonantesByNombreAndApellido(@RequestParam String nombre, @RequestParam String apellido){
        return donanteService.getDonantesByNombreAndApellido(nombre, apellido);
    }

    @GetMapping("/all")
    public List<Donante> getAllDonantes(){
        return donanteService.getAllDonantes();
    }

}
