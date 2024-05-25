package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Entities.Suministro;
import com.example.gestorancianato.Services.SuministroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/Suministro")
public class SuministroController {
    private  final SuministroService suministroService;

    public SuministroController(SuministroService suministroService) {
        this.suministroService = suministroService;
    }

    @PostMapping ("/Registrar")
    public ResponseEntity<Suministro> registrarSuministro(@RequestBody Suministro suministro){
        return new ResponseEntity<>(suministroService.createSuministro(suministro),HttpStatus.CREATED);
    }

    @PutMapping ("/Actualizar/{id}")
    public ResponseEntity<Suministro> updateSuministro(@PathVariable Integer id, @RequestBody Suministro suministro){
        return new ResponseEntity<>(suministroService.updateSuministro(id, suministro).orElse(null), HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteSuministro(@PathVariable Integer id){
        suministroService.deleteSuministroById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping ("/all")
    public List<Suministro> getAllSuministros(){
        return suministroService.getAllSuministros();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Suministro> getSuministroById(@PathVariable Integer id){
        return new ResponseEntity<>(suministroService.getSuministroById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping ("/fecha/{fechaInicio}/{fechaFin}")
    public ResponseEntity<Suministro> getSuministroByFecha(@PathVariable LocalDate fechaInicio, @PathVariable LocalDate fechaFin){
        return new ResponseEntity<>(suministroService.getSuministroByFecha(fechaInicio, fechaFin).orElse(null), HttpStatus.OK);
    }

    @GetMapping ("/medicamento/{medicamento}")
    public List<Suministro> getSuministroByMedicamento(@PathVariable String medicamento){
        return suministroService.getSuministroByMedicamento(medicamento);
    }

    @GetMapping ("/adultoMayor/{cedula}")
    public List<Suministro> getSuministroByAdultoMayor(@PathVariable Integer cedula){
        return suministroService.getSuministroByAdultoMayor(cedula);
    }

}
