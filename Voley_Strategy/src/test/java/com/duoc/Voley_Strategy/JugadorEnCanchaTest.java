package com.duoc.Voley_Strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.duoc.Voley_Strategy.controller.JugadorController;
import com.duoc.Voley_Strategy.DTO.JugadorCanchaDTO;
import com.duoc.Voley_Strategy.model.Jugador;
import com.duoc.Voley_Strategy.service.JugadorService;

@ExtendWith(MockitoExtension.class)
public class JugadorEnCanchaTest {

    @Mock
    private JugadorService jugadorService; 

    @InjectMocks
    private JugadorController jugadorController; 

    @Test
    void ObtenerJugadorEnCanchaRetorna200_CuandoJugadorExiste() {

        Jugador jugadorSimulado = new Jugador(1, "Juan", "Pérez", 185, null, "2023-01-15", "Opuesto", null, null, null);
        

        when(jugadorService.seleccionarJugador(1)).thenReturn(jugadorSimulado);


        ResponseEntity<JugadorCanchaDTO> respuesta = jugadorController.obtenerJugadorEnCancha(1);

        assertNotNull(respuesta, "La respuesta no puede ser nula");
        assertEquals(HttpStatus.OK, respuesta.getStatusCode(), "Debe retornar un código HTTP 200 OK");
        JugadorCanchaDTO body = respuesta.getBody();
        assertNotNull(body, "El cuerpo del DTO no puede venir vacío");
        assertEquals("Opuesto", body.getRol(), "El rol asignado al jugador no coincide");
        assertEquals(1, body.getPosicion(), "La posición en rotación no coincide");
    }
}
