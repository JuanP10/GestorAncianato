package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Dtos.DonanteDto;
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

    @PostMapping
    public ResponseEntity<DonanteDto> registrarDonante(@RequestBody DonanteDto donante){
        return new ResponseEntity<>(donanteService.createDonante(donante), HttpStatus.CREATED);
    }

    @PutMapping ("/{cedula}")
    public ResponseEntity<DonanteDto> updateDonante(@PathVariable Integer cedula, @RequestBody DonanteDto donante){
        return new ResponseEntity<>(donanteService.updateDonante(cedula, donante), HttpStatus.OK);
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<String> deleteDonante(@PathVariable Integer cedula){
        donanteService.deleteDonante(cedula);
        return new ResponseEntity<>("Donante eliminado", HttpStatus.OK);
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<DonanteDto> getDonanteByCedula(@PathVariable Integer cedula){
        return new ResponseEntity<>(donanteService.getDonanteByCedula(cedula), HttpStatus.OK);
    }

    @GetMapping("/nombre&apellido")
    public ResponseEntity<List<DonanteDto>> getDonantesByNombreAndApellido(@RequestParam String nombre, @RequestParam String apellido){
        return new ResponseEntity<>(donanteService.getDonantesByNombreAndApellido(nombre, apellido), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DonanteDto>> getAllDonantes(){
        return new ResponseEntity<>(donanteService.getAllDonantes(), HttpStatus.OK);
    }

}
