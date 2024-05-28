package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Dtos.CategoriaMedicamentoDto;
import com.example.gestorancianato.Entities.CategoriaMedicamento;
import com.example.gestorancianato.Services.CategoriaMedicamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Categoria")
public class CategoriaController {
    private final CategoriaMedicamentoService categoriaMedicamentoService;

    public CategoriaController(CategoriaMedicamentoService categoriaMedicamentoService) {
        this.categoriaMedicamentoService = categoriaMedicamentoService;
    }

    @PostMapping()
    public ResponseEntity<CategoriaMedicamentoDto> registrarCategoria(@RequestBody CategoriaMedicamentoDto categoriaMedicamento){
        return new ResponseEntity<>(categoriaMedicamentoService.createCategoria(categoriaMedicamento), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaMedicamentoDto> updateCategoria(@PathVariable Integer id, @RequestBody CategoriaMedicamentoDto categoriaMedicamento){
        return new ResponseEntity<>(categoriaMedicamentoService.updateCategoria(id, categoriaMedicamento), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable Integer id){
        categoriaMedicamentoService.deleteCategoriaById(id);
        return new ResponseEntity<>("Categoria eliminada", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaMedicamentoDto> getCategoriaById(@PathVariable Integer id){
        CategoriaMedicamentoDto categoriaMedicamento = categoriaMedicamentoService.getCategoriaById(id);
        return new ResponseEntity<>(categoriaMedicamento, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoriaMedicamentoDto>> getAllCategorias(){
        List<CategoriaMedicamentoDto> categorias = categoriaMedicamentoService.getAllCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }


}
