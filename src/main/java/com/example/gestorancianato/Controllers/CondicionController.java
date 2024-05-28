package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Entities.CondicionMedica;
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
    public ResponseEntity <CondicionMedica> createConcion (@RequestBody CondicionMedica condicionMedica){
        return new ResponseEntity <>(condicionService.createCondicion(condicionMedica), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity <CondicionMedica> updateCondicion (@PathVariable Integer id, @RequestBody CondicionMedica condicionMedica){
        return new ResponseEntity <>(condicionService.updateCondicion(id, condicionMedica).orElse(null), HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> deleteCondicion (@PathVariable Integer id){
        condicionService.deleteCondicionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping ("/all")
    public List<CondicionMedica> getAllCondicion(){
        return condicionService.getAllCondiciones();
    }

    @GetMapping ("/{id}")
    public ResponseEntity <CondicionMedica> getCondicionById (@PathVariable Integer id){
        return new ResponseEntity<>(condicionService.getCondicionById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping ("/nombre/{nombre}")
    public ResponseEntity <CondicionMedica> getCondicionByNombre (@PathVariable String nombre){
        return new ResponseEntity<>(condicionService.getCondicionByNombre(nombre).orElse(null), HttpStatus.OK);
    }


}
