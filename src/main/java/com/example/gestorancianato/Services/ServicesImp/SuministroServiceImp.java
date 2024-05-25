package com.example.gestorancianato.Services.ServicesImp;

import com.example.gestorancianato.Entities.Suministro;
import com.example.gestorancianato.Repositories.SuministroRepository;
import com.example.gestorancianato.Services.SuministroService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SuministroServiceImp implements SuministroService {

    private final SuministroRepository suministroRepository;

    public SuministroServiceImp(SuministroRepository suministroRepository) {
        this.suministroRepository = suministroRepository;
    }


    @Override
    public Suministro createSuministro(Suministro suministro) {
        return suministroRepository.save(suministro);
    }

    @Override
    public List<Suministro> getAllSuministros() {
        return suministroRepository.findAll();
    }

    @Override
    public Optional<Suministro> updateSuministro(Integer id, Suministro suministro) {
        Optional<Suministro> optionalSuministro = suministroRepository.findById(id);
        if (optionalSuministro.isPresent()) {
            Suministro suministroToUpdate = optionalSuministro.get();
            suministroToUpdate.setFechaSuministro(suministro.getFechaSuministro());
            suministroToUpdate.setCantidad(suministro.getCantidad());
            suministroToUpdate.setMedicamento(suministro.getMedicamento());
            suministroToUpdate.setAdultoMayor(suministro.getAdultoMayor());
            return Optional.of(suministroRepository.save(suministroToUpdate));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteSuministroById(Integer id) {
        suministroRepository.deleteById(id);

    }

    @Override
    public Optional<Suministro> getSuministroById(Integer id) {
        return suministroRepository.findById(id);
    }

    @Override
    public Optional<Suministro> getSuministroByFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        return suministroRepository.findByFechaSuministroBetween(fechaInicio, fechaFin);
    }

    @Override
    public List<Suministro> getSuministroByMedicamento(String medicamento) {
        return suministroRepository.findSuministrosByMedicamento(medicamento);
    }

    @Override
    public List<Suministro> getSuministroByAdultoMayor(Integer cedula) {
        return suministroRepository.findSuministrosByAdultoMayor_Cedula(cedula);
    }

}
