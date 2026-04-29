package com.duoc.Voley_Strategy.repository;

import com.duoc.Voley_Strategy.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    
    List<Equipo> findBynombreEquipo(String nombreEquipo);

    List<Equipo> findByDuenoPunto(boolean duenoPunto);
}
