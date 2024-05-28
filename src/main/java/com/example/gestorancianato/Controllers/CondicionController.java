package com.example.gestorancianato.Controllers;

import com.example.gestorancianato.Dtos.CondicionMedicaDto;
import com.example.gestorancianato.Entities.CondicionMedica;
import com.example.gestorancianato.Services.CondicionMedicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/condicion")
public class CondicionController {
    private final CondicionMedicaService condicionMedicaService;

    public CondicionController(CondicionMedicaService condicionMedicaService) {
        this.condicionMedicaService = condicionMedicaService;
    }

    @PostMapping()
    public ResponseEntity <CondicionMedicaDto> createConcion (@RequestBody CondicionMedicaDto condicionMedica){
        return new ResponseEntity <>(condicionMedicaService.createCondicion(condicionMedica), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity <CondicionMedicaDto> updateCondicion (@PathVariable Integer id, @RequestBody CondicionMedicaDto condicionMedica){
        CondicionMedicaDto condicionMedicaDto = condicionMedicaService.updateCondicion(id, condicionMedica);
        return new ResponseEntity<>(condicionMedicaDto, HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <String> deleteCondicion (@PathVariable Integer id){
        condicionMedicaService.deleteCondicionById(id);
        return new ResponseEntity<>("Condicion Medica eliminada", HttpStatus.OK);
    }

    @GetMapping ("/all")
    public ResponseEntity<List<CondicionMedicaDto>> getAllCondicion(){
        List<CondicionMedicaDto> condicionMedicaDtoList = condicionMedicaService.getAllCondiciones();
        return new ResponseEntity<>(condicionMedicaDtoList, HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity <CondicionMedicaDto> getCondicionById (@PathVariable Integer id){
        CondicionMedicaDto condicionMedicaDto = condicionMedicaService.getCondicionById(id);
        return new ResponseEntity<>(condicionMedicaDto, HttpStatus.OK);
    }

    @GetMapping ("/nombre/{nombre}")
    public ResponseEntity <CondicionMedicaDto> getCondicionByNombre (@PathVariable String nombre){
        CondicionMedicaDto condicionMedicaDto = condicionMedicaService.getCondicionByNombre(nombre);
        return new ResponseEntity<>(condicionMedicaDto, HttpStatus.OK);
    }


}
