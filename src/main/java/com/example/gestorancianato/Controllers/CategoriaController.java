package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Entities.CategoriaMedicamento;
import com.example.gestorancianato.Services.CategoriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/Registrar")
    public ResponseEntity<CategoriaMedicamento> registrarCategoria(@RequestBody CategoriaMedicamento categoriaMedicamento){
        return new ResponseEntity<>(categoriaService.createCategoria(categoriaMedicamento), HttpStatus.CREATED);
    }

    @PutMapping("Actualizar/{id}")
    public ResponseEntity<CategoriaMedicamento> updateCategoria(@PathVariable Integer id, @RequestBody CategoriaMedicamento categoriaMedicamento){
        return new ResponseEntity<>(categoriaService.updateCategoria(id, categoriaMedicamento).orElse(null), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id){
        categoriaService.deleteCategoriaById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaMedicamento> getCategoriaById(@PathVariable Integer id){
        return new ResponseEntity<>(categoriaService.getCategoriaById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<CategoriaMedicamento> getAllCategorias(){
        return categoriaService.getAllCategorias();
    }


}
