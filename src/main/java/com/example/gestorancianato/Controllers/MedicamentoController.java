package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Dtos.MedicamentoDto;
import com.example.gestorancianato.Entities.Medicamento;
import com.example.gestorancianato.Services.MedicamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Medicamento")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    public ResponseEntity<MedicamentoDto> registrarMedicamento(@RequestBody @Validated MedicamentoDto medicamento) {
        try {
            MedicamentoDto createdMedicamento = medicamentoService.createMedicamento(medicamento);
            return new ResponseEntity<>(createdMedicamento, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    /*
    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoDto> updateMedicamento(@PathVariable Integer id, @RequestBody MedicamentoDto medicamento){
        try {
            Optional<MedicamentoDto> updatedMedicamento = medicamentoService.updateMedicamento(id, medicamento);
            return updatedMedicamento.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

     */

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedicamento(@PathVariable Integer id){
        medicamentoService.deleteMedicamentoById(id);
        return new ResponseEntity<>("Medicamento eliminado", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDto> getMedicamentoById(@PathVariable Integer id){
        return new ResponseEntity<>(medicamentoService.getMedicamentoById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MedicamentoDto>> getAllMedicamentos(){
        return new ResponseEntity<>(medicamentoService.getAllMedicamentos(), HttpStatus.OK);
    }

    @GetMapping("/catMedicamentos")
    public ResponseEntity<List<MedicamentoDto>> getMedicamentosByCatMedicamentos(@RequestParam String catMedicamentos){
        List<MedicamentoDto> medicamentos = medicamentoService.getMedicamentosByCatMedicamentos(catMedicamentos);
        return new ResponseEntity<>(medicamentos, HttpStatus.OK);
    }

    @GetMapping("/donanteCedula")
    public ResponseEntity<List<MedicamentoDto>> getMedicamentoByDonanteCedula(@RequestParam Integer cedula){
        List<MedicamentoDto> medicamentos = medicamentoService.getMedicamentoByDonanteCedula(cedula);
        return new ResponseEntity<>(medicamentos, HttpStatus.OK);
    }

    @GetMapping("/fechaVencimiento")
    public ResponseEntity<List<MedicamentoDto>> getMedicamentoByFechaVencimientoMesAndAño(@RequestParam int mes, @RequestParam int año){
        List<MedicamentoDto> medicamentos = medicamentoService.getMedicamentoByFechaVencimientoMesAndAño(mes, año);
        return new ResponseEntity<>(medicamentos, HttpStatus.OK);
    }

}
