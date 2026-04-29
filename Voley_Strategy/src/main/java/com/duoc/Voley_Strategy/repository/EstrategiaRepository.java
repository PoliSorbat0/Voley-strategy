package com.duoc.Voley_Strategy.repository;

import com.duoc.Voley_Strategy.model.Estrategia;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EstrategiaRepository extends JpaRepository<Estrategia, Integer> {
    List<Estrategia> findByNombreEstrategia(String nombreEstrategia);
}
