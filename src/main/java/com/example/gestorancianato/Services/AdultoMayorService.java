package com.example.gestorancianato.Services;

import com.example.gestorancianato.Entities.AdultoMayor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
public interface AdultoMayorService {
    AdultoMayor createAdultoMayor(AdultoMayor adultoMayor);

    List<AdultoMayor> getAllAdultoMayor();

    Optional<AdultoMayor> GetAdultoMayorByCedula(Integer cedula);

    Optional<AdultoMayor> updateAdultoMayor(Integer cedula, AdultoMayor adultoMayor);

    void deleteAdultoMayor(Integer cedula);

    List<AdultoMayor> getAdultoMayorByNombreAndApellido(String nombre, String apellido);

    Optional<AdultoMayor> findByAdultoMayorByCondicionMedica(String CondicionMedica);


}
