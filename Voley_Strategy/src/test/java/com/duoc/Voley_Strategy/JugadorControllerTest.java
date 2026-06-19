package com.duoc.Voley_Strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.duoc.Voley_Strategy.controller.JugadorController;
import com.duoc.Voley_Strategy.model.Jugador;
import com.duoc.Voley_Strategy.repository.JugadorRepository;

@ExtendWith(MockitoExtension.class)

public class JugadorControllerTest {
    
    @InjectMocks
    private JugadorRepository jugadorRepository;

    @Mock
    private JugadorController jugadorController;

    @Test
    void crearJugador_retorna201_cuandoJugadorEsCorrecto() {

    Jugador jugador = new Jugador(1, "Juan", "Pérez", 185, null, "2023-01-15", "Opuesto", null, null, null);
    when(jugadorRepository.save(any(Jugador.class))).thenReturn(jugador);

    ResponseEntity<Jugador> respuesta = jugadorController.crearJugador(jugador);

    assertNotNull(respuesta, "No puede ser nula");
    assertEquals(HttpStatus.CREATED, respuesta.getStatusCode(), "Debe ser 201 CREATED");
    assertNotNull(respuesta.getBody(), "El body no puede estar vacío");
    assertEquals("Juan", respuesta.getBody().getNombre(), "El nombre del Jugador guardado no coincide");
    assertEquals("Pérez", respuesta.getBody().getApellido(), "El apellido del Jugador guardado no coincide");
    assertEquals(185, respuesta.getBody().getAltura(), "La altura del Jugador guardado no coincide");

 
    }
}
