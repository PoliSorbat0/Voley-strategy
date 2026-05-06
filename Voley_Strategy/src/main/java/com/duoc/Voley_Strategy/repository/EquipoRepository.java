package com.duoc.Voley_Strategy.repository;

import com.duoc.Voley_Strategy.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

    // Cambiar el nombre de un equipo por su ID
    @Transactional
    @Modifying
    @Query("UPDATE Equipo e SET e.nombreEquipo = :nuevoNombre WHERE e.id = :id")
    int updateNombreEquipo(@Param("id") Integer id, @Param("nuevoNombre") String nuevoNombre);

    // Buscar por nombre 
    List<Equipo> findByNombreEquipo(String nombreEquipo);

    // Identificar al dueño del punto
    List<Equipo> findByDuenoPunto(boolean duenoPunto);
}