package com.example.gestorancianato.Services;

import com.example.gestorancianato.Entities.Suministro;




import java.util.List;
import java.time.LocalDate;
import java.util.Optional;


public interface SuministroService {

    Suministro createSuministro(Suministro suministro);

    List<Suministro> getAllSuministros();

    Optional<Suministro> updateSuministro(Integer id, Suministro suministro);

    void deleteSuministroById(Integer id);

    Optional<Suministro> getSuministroById(Integer id);





}
