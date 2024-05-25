package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Entities.CatMedicamento;
import com.example.gestorancianato.Services.CatMedicamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/catMedicamento")
public class CatMedicamentoController {
    private final CatMedicamentoService catMedicamentoService;

    public CatMedicamentoController(CatMedicamentoService catMedicamentoService) {
        this.catMedicamentoService = catMedicamentoService;
    }

    @PostMapping ("/registrar")
    public ResponseEntity<CatMedicamento> registrarCatMedicamento(@RequestBody CatMedicamento catMedicamento){
        return new ResponseEntity<>(catMedicamentoService.createCatMedicamento(catMedicamento), HttpStatus.CREATED);
    }

    @PostMapping ("/actualizar/{id}")
    public ResponseEntity<CatMedicamento> updateCatMedicamento(@PathVariable Integer id, @RequestBody CatMedicamento catMedicamento){
        return new ResponseEntity<>(catMedicamentoService.updateCatMedicamento(id, catMedicamento).orElse(null), HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteCatMedicamento(@PathVariable Integer id){
        catMedicamentoService.deleteCatMedicamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<CatMedicamento> getCatMedicamentoById(@PathVariable Integer id){
        return new ResponseEntity<>(catMedicamentoService.getCatMedicamentoById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping ("/all")
    public List<CatMedicamento> getAllCatMedicamentos(){
        return catMedicamentoService.getAllCatMedicamentos();
    }

    @GetMapping ("/categoria/{categoria}")
    public ResponseEntity<CatMedicamento> getCatMedicamentoByCategoria(@PathVariable String categoria){
        return new ResponseEntity<>(catMedicamentoService.getCatMedicamentoByCategoria(categoria).orElse(null), HttpStatus.OK);
    }

    @GetMapping ("/medicamento/{medicamento}")
    public ResponseEntity<CatMedicamento> getCatMedicamentoByMedicamento(@PathVariable String medicamento){
        return new ResponseEntity<>(catMedicamentoService.getCatMedicamentoByMedicamento(medicamento).orElse(null), HttpStatus.OK);
    }


}
