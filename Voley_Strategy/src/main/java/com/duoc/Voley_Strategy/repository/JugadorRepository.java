package com.duoc.Voley_Strategy.repository;

import com.duoc.Voley_Strategy.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
    //Rol
    List<Jugador> findByRol(String rol);

    //Posición dentro de la cancha
    List<Jugador> findByPosicion(Integer posicion);

    //Ambas
    List<Jugador> findByRolAndPosicion(String rol, Integer posicion); 
}
