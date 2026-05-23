package com.duoc.Voley_Strategy.controller;

import com.duoc.Voley_Strategy.model.Equipo;
import com.duoc.Voley_Strategy.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "*") 
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    // Crear un nuevo equipo
    @PostMapping
    public ResponseEntity<Equipo> crear(@RequestBody Equipo equipo) {
        Equipo nuevoEquipo = equipoService.registrarEquipo(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEquipo);
    }

    // Listar todos los equipos
    @GetMapping
    public ResponseEntity<List<Equipo>> obtenerTodos() {
        return ResponseEntity.ok(equipoService.listarTodos());
    }

    // Obtener un equipo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> obtenerPorId(@PathVariable Integer id) {
        Equipo equipo = equipoService.seleccionarEquipo(id);
        if (equipo == null) {
            throw new NoSuchElementException("No se encontró el equipo con el ID: " + id);
        }
        return ResponseEntity.ok(equipo);
    }

    // Cambiar el nombre de un equipo
    @PutMapping("/{id}")
    public ResponseEntity<String> renombrar(@PathVariable Integer id, @RequestParam String nuevoNombre) {
        Equipo equipo = equipoService.seleccionarEquipo(id);
        if (equipo == null) {
            throw new NoSuchElementException("No se puede actualizar. El equipo con ID " + id + " no existe.");
        }
        equipoService.modificarNombre(id, nuevoNombre);
        return ResponseEntity.ok("Nombre actualizado correctamente a: " + nuevoNombre);
    }

    // Eliminar un equipo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        Equipo equipo = equipoService.seleccionarEquipo(id);
        if (equipo == null) {
            throw new NoSuchElementException("No se puede eliminar. El equipo con ID " + id + " no existe.");
        }
        
        equipoService.eliminarEquipo(id); 
        
        return ResponseEntity.ok("Equipo eliminado correctamente.");
    }

}