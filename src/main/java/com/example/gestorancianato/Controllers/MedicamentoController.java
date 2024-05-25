package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Entities.Medicamento;
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

    @PostMapping("/Registrar")
    public ResponseEntity<Medicamento> registrarMedicamento(@RequestBody Medicamento medicamento){
        return new ResponseEntity<>(medicamentoService.createMedicamento(medicamento), HttpStatus.CREATED);
    }

    @PutMapping("Actualizar/{id}")
    public ResponseEntity<Medicamento> updateMedicamento(@PathVariable Integer id, @RequestBody Medicamento medicamento){
        return new ResponseEntity<>(medicamentoService.updateMedicamento(id, medicamento).orElse(null), HttpStatus.OK);
    }

    @PostMapping("Eliminar/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable Integer id){
        medicamentoService.deleteMedicamentoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable Integer id){
        return new ResponseEntity<>(medicamentoService.getMedicamentoById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Medicamento> getAllMedicamentos(){
        return medicamentoService.getAllMedicamentos();
    }

    @GetMapping("/catMedicamentos")
    public List<Medicamento> getMedicamentosByCatMedicamentos(@RequestParam String catMedicamentos){
        return medicamentoService.getMedicamentosByCatMedicamentos(catMedicamentos);
    }

    @GetMapping("/donanteCedula")
    public List<Medicamento> getMedicamentoByDonanteCedula(@RequestParam Integer cedula){
        return medicamentoService.getMedicamentoByDonanteCedula(cedula);
    }

    @GetMapping("/fechaVencimiento")
    public List<Medicamento> getMedicamentoByFechaVencimientoMesAndAño(@RequestParam int mes, @RequestParam int año){
        return medicamentoService.getMedicamentoByFechaVencimientoMesAndAño(mes, año);
    }

}
