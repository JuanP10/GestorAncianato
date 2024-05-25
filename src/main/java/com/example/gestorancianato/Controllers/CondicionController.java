package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Entities.Condicion;
import com.example.gestorancianato.Services.CondicionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condicion")
public class CondicionController {
    private final CondicionService condicionService;

    public CondicionController(CondicionService condicionService) {
        this.condicionService = condicionService;
    }

    @PostMapping("/registrar")
    public ResponseEntity <Condicion> createConcion (@RequestBody Condicion condicion){
        return new ResponseEntity <>(condicionService.createCondicion(condicion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Condicion> updateCondicion (@PathVariable Integer id, @RequestBody Condicion condicion){
        return new ResponseEntity <>(condicionService.updateCondicion(id, condicion).orElse(null), HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> deleteCondicion (@PathVariable Integer id){
        condicionService.deleteCondicionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping ("/all")
    public List<Condicion> getAllCondicion(){
        return condicionService.getAllCondiciones();
    }

    @GetMapping ("/{id}")
    public ResponseEntity <Condicion> getCondicionById (@PathVariable Integer id){
        return new ResponseEntity<>(condicionService.getCondicionById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping ("/nombre/{nombre}")
    public ResponseEntity <Condicion> getCondicionByNombre (@PathVariable String nombre){
        return new ResponseEntity<>(condicionService.getCondicionByNombre(nombre).orElse(null), HttpStatus.OK);
    }


}
