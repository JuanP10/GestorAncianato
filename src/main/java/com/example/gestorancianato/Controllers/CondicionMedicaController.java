package com.example.gestorancianato.Controllers;



import com.example.gestorancianato.Entities.CondicionMedica;
import com.example.gestorancianato.Services.CondicionMedicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/CondicionMedica")
public class CondicionMedicaController {
    private final CondicionMedicaService condicionMedicaService;


    public CondicionMedicaController(CondicionMedicaService condicionMedicaService) {
        this.condicionMedicaService = condicionMedicaService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<CondicionMedica> registrarCondicionMedica(@RequestBody CondicionMedica condicionMedica){
        return new ResponseEntity<>(condicionMedicaService.createCondicionMedica(condicionMedica), HttpStatus.CREATED);
    }
    @PutMapping ("/actualizar/{id}")
    public ResponseEntity<CondicionMedica> updateCondicionMedica(@PathVariable Integer id, @RequestBody CondicionMedica condicionMedica){
        return new ResponseEntity<>(condicionMedicaService.updateCondicionMedica(id, condicionMedica).orElse(null), HttpStatus.OK);
    }
    @DeleteMapping ("/{id}")
    public ResponseEntity<Void> deleteCondicionMedica(@PathVariable Integer id){
        condicionMedicaService.deleteCondicionMedica(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping ("/{id}")
    public ResponseEntity<CondicionMedica> getCondicionMedicaById(@PathVariable Integer id){
        return new ResponseEntity<>(condicionMedicaService.getCondicionMedicaById(id).orElse(null), HttpStatus.OK);
    }
    @GetMapping ("/all")
    public ResponseEntity<?> getAllCondicionMedica(){
        return new ResponseEntity<>(condicionMedicaService.getAllCondicionMedica(), HttpStatus.OK);
    }

}
