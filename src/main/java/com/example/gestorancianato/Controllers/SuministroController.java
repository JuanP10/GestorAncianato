package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Dtos.SuministroDto;
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

    @PostMapping
    public ResponseEntity<SuministroDto> registrarSuministro(@RequestBody SuministroDto suministro){
        return new ResponseEntity<>(suministroService.createSuministro(suministro),HttpStatus.CREATED);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<SuministroDto> updateSuministro(@PathVariable Integer id, @RequestBody SuministroDto suministro){
         SuministroDto suministroDto = suministroService.updateSuministro(id, suministro);
         return new ResponseEntity<>(suministroDto, HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> deleteSuministro(@PathVariable Integer id){
        suministroService.deleteSuministroById(id);
        return new ResponseEntity<>("Suministro eliminado", HttpStatus.OK);
    }

    @GetMapping ("/all")
    public ResponseEntity<List<SuministroDto>> getAllSuministros(){
        List<SuministroDto> suministros = suministroService.getAllSuministros();
        return new ResponseEntity<>(suministros, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<SuministroDto> getSuministroById(@PathVariable Integer id){
        return new ResponseEntity<>(suministroService.getSuministroById(id), HttpStatus.OK);
    }

    @GetMapping ("/fecha/{fechaInicio}/{fechaFin}")
    public List<ResponseEntity<SuministroDto>> getSuministrosByFecha(@PathVariable LocalDate fechaInicio, @PathVariable LocalDate fechaFin){
        List<SuministroDto> suministros = suministroService.getSuministrosByFecha(fechaInicio, fechaFin);
        return suministros.stream().map(ResponseEntity::ok).toList();
    }

    @GetMapping ("/medicamento/{medicamento}")
    public ResponseEntity<List<SuministroDto>> getSuministroByMedicamento(@PathVariable String medicamento){
        List<SuministroDto> suministros = suministroService.getSuministrosByMedicamento(medicamento);
        return new ResponseEntity<>(suministros, HttpStatus.OK);
    }

    @GetMapping ("/adultoMayor/{cedula}")
    public ResponseEntity<List<SuministroDto>> getSuministroByAdultoMayor(@PathVariable Integer cedula){
        List<SuministroDto> suministros = suministroService.getSuministrosByAdultoMayor(cedula);
        return new ResponseEntity<>(suministros, HttpStatus.OK);
    }

}
