package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Dtos.MedicamentoDto;
import com.example.gestorancianato.Services.MedicamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Medicamento")
public class MedicamentoController {

    private final MedicamentoService medicamentoService;

    public MedicamentoController(MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    @PostMapping
    public ResponseEntity<MedicamentoDto> registrarMedicamento(@RequestBody MedicamentoDto medicamento){
        return new ResponseEntity<>(medicamentoService.createMedicamento(medicamento), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoDto> updateMedicamento(@PathVariable Integer id, @RequestBody MedicamentoDto medicamento){
        return new ResponseEntity<>(medicamentoService.updateMedicamento(id, medicamento), HttpStatus.OK);
    }

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
        List<MedicamentoDto> medicamentos = medicamentoService.getAllMedicamentos();
        return new ResponseEntity<>(medicamentos, HttpStatus.OK);
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
