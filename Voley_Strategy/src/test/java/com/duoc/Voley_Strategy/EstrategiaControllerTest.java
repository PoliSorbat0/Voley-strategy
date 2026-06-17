package com.duoc.Voley_Strategy;

import com.duoc.Voley_Strategy.controller.EstrategiaController;
import com.duoc.Voley_Strategy.model.Equipo;
import com.duoc.Voley_Strategy.model.Estrategia;
import com.duoc.Voley_Strategy.repository.EstrategiaRepository; 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EstrategiaControllerTest {

    @Mock
    private EstrategiaRepository estrategiaRepository; 

    @InjectMocks
    private EstrategiaController estrategiaController;

    @Test
    void crearEstrategia_retorna201_cuandoEstrategiaesCorrecta() {

        Equipo equipo = new Equipo(1, "Linces Volley", "Naranjo", "Negro", "2023-05-12", true, new ArrayList<>(), new ArrayList<>());
        Estrategia estrategia = new Estrategia(1, "Ataque tipo 'metro' del punta por zona de 3, con el central atacando 'Desplazada' ", "Cruce", equipo);


        when(estrategiaRepository.save(any(Estrategia.class))).thenReturn(estrategia);


        ResponseEntity<Estrategia> respuesta = estrategiaController.crearEstrategia(estrategia);


        assertNotNull(respuesta, "No puede ser nula");
        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode(), "Debe ser 201 CREATED");
        
        Estrategia body = respuesta.getBody();
        assertNotNull(body, "El body no puede estar vacío");
        assertEquals("Cruce", body.getNombreEstrategia(), "El nombre de la estrategia guardada no coincide");
        assertEquals("Ataque tipo 'metro' del punta por zona de 3, con el central atacando 'Desplazada' ", body.getDescripcionEstrategia(), "La descripción de la estrategia no coincide");
        
    
        assertEquals("Linces Volley", body.getEquipo().getNombreEquipo(), "El equipo asignado a la estrategia no es el mismo");
    }
}