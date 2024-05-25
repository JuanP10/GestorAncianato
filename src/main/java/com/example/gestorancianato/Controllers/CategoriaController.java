package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Entities.Categoria;
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
    public ResponseEntity<Categoria> registrarCategoria(@RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.createCategoria(categoria), HttpStatus.CREATED);
    }

    @PutMapping("Actualizar/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria){
        return new ResponseEntity<>(categoriaService.updateCategoria(id, categoria).orElse(null), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id){
        categoriaService.deleteCategoriaById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Integer id){
        return new ResponseEntity<>(categoriaService.getCategoriaById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Categoria> getAllCategorias(){
        return categoriaService.getAllCategorias();
    }


}
