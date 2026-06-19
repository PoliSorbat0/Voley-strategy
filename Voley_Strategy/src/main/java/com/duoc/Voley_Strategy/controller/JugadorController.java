package com.duoc.Voley_Strategy.controller;

import com.duoc.Voley_Strategy.DTO.JugadorCanchaDTO;
import com.duoc.Voley_Strategy.model.Jugador;
import com.duoc.Voley_Strategy.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/jugadores")
@CrossOrigin(origins = "*")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    // Listar todos los jugadores
    @GetMapping
    public ResponseEntity<List<Jugador>> obtenerTodos() {
        return ResponseEntity.ok(jugadorService.listarTodos());
    }

    // Obtener un jugador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Jugador> obtenerPorId(@PathVariable Integer id) {
        Jugador jugador = jugadorService.seleccionarJugador(id);
        if (jugador == null) {
            throw new NoSuchElementException("No se encontró el jugador con el ID: " + id);
        }
        return ResponseEntity.ok(jugador);
    }

    // Crear un nuevo jugador
    @PostMapping
    public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador jugador) {
        Jugador nuevoJugador = jugadorService.registrarJugador(jugador);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoJugador);
    }

    // Eliminar un jugador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarJugador(@PathVariable Integer id) {
        Jugador jugador = jugadorService.seleccionarJugador(id);
        if (jugador == null) {
            throw new NoSuchElementException("No se puede eliminar. No existe el jugador con ID: " + id);
        }
        jugadorService.eliminarJugador(id);
        return ResponseEntity.noContent().build();
    }

    // Modificar el nombre de un jugador
    @PutMapping("/{id}")
    public ResponseEntity<String> modificarNombre(@PathVariable Integer id, @RequestParam String nuevoNombre) {
        Jugador jugador = jugadorService.seleccionarJugador(id);
        if (jugador == null) {
            throw new NoSuchElementException("No se puede actualizar. El jugador con ID " + id + " no existe.");
        }
        jugadorService.modificarNombre(id, nuevoNombre);
        return ResponseEntity.ok("Nombre actualizado correctamente a: " + nuevoNombre);
    }
    //Llamar al jugador en cancha (Jugador DTO)
    @GetMapping("/{id}/en-cancha")
    public ResponseEntity<JugadorCanchaDTO> obtenerJugadorEnCancha(@PathVariable Integer id) {
        Jugador jugador = jugadorService.seleccionarJugador(id);
        if (jugador == null) {
            throw new NoSuchElementException("No se encontró el jugador con el ID: " + id);
        }
        
  
        JugadorCanchaDTO dto = new JugadorCanchaDTO(jugador.getPosicion(), 1); 
        
        return ResponseEntity.ok(dto);
    }

    
}