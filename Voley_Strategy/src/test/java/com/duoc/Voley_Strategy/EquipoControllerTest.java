package com.duoc.Voley_Strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks; 
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.duoc.Voley_Strategy.controller.EquipoController; 
import com.duoc.Voley_Strategy.model.Equipo;
import com.duoc.Voley_Strategy.service.EquipoService;

@ExtendWith(MockitoExtension.class)
public class EquipoControllerTest {

    @InjectMocks 
    private EquipoController equipoController;
    
    @Mock 
    private EquipoService equipoService;

    @Test
    void CrearEquipoRetorna201_CuandoEquipoEsValido() {
        // 1. Preparación del escenario (Given)
        Equipo equipoEntrada = new Equipo(1, "Linces Volley", "Naranjo", "Negro", "2023-05-12", true, new ArrayList<>(), new ArrayList<>());
        when(equipoService.registrarEquipo(any(Equipo.class))).thenReturn(equipoEntrada);

        // 2. Ejecución de la acción (When)
        ResponseEntity<Equipo> respuesta = equipoController.crear(equipoEntrada);
    
        // 3. Verificaciones (Then)
        assertNotNull(respuesta, "No puede ser nula");
        assertEquals(HttpStatus.CREATED, respuesta.getStatusCode(), "Debe ser 201 CREATED");
        
        Equipo body = respuesta.getBody();
        assertNotNull(body, "El body no puede estar vacío");
        assertEquals("Linces Volley", body.getNombreEquipo(), "El nombre del equipo guardado no coincide");
        assertEquals("Naranjo", body.getColorPrimario(), "El color primario del equipo guardado no coincide");
        assertEquals("Negro", body.getColorSecundario(), "El color secundario del equipo guardado no coincide");
        assertEquals("2023-05-12", body.getFechaFundacion(), "La fecha de fundación del equipo guardado no coincide");
    }
}
