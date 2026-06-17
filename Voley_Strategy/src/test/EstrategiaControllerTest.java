package com.duoc.Voley_Strategy.controller;

import com.duoc.Voley_Strategy.model.Equipo;
import com.duoc.Voley_Strategy.model.Estrategia;
import com.duoc.Voley_Strategy.service.EstrategiaService;
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
    private EstrategiaService estrategiaService;

    @InjectMocks
    private EstrategiaController estrategiaController;

    @Test
    void crearEstrategia_retorna201_cuandoDatosSonValidos() {

        // 1. Arrange: Preparamos los datos de prueba 
        Equipo equipo = new Equipo(1, "Los Jaguares VBC", "Azul", "Blanco", "2015-05-12", true, new ArrayList<>(), new ArrayList<>());
        Estrategia estrategia = new Estrategia(1, "Ataque rápido por zona 3 con finta del central", "Sistema 4-2 Infiltrado", equipo);

        // Simulamos el comportamiento del servicio usando 'any' para evitar conflictos de memoria
        when(estrategiaService.saveEstrategia(any(Estrategia.class))).thenReturn(estrategia);

        // 2. Act: Llamamos al método del controlador de estrategias que queremos probar
        ResponseEntity<Estrategia> respuesta = estrategiaController.agregarEstrategia(estrategia);

        // 3. Assert: Verificaciones exhaustivas del éxito de la operación
        assertNotNull(respuesta, "La respuesta del controlador no debería ser nula");
        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode(), "El código de estado de respuesta debe ser 201 CREATED");
        
        Estrategia body = respuesta.getBody();
        assertNotNull(body, "El cuerpo de la respuesta no debe venir vacío");
        assertEquals("Sistema 4-2 Infiltrado", body.getNombreEstrategia(), "El nombre de la estrategia guardada no coincide");
        assertEquals("Ataque rápido por zona 3 con finta del central", body.getDescripcionEstrategia(), "La descripción de la estrategia no coincide");
        assertEquals("Los Jaguares VBC", body.getEquipo().getNombreEquipo(), "El equipo asignado a la estrategia no es el correcto");
    }
} 