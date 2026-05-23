package com.duoc.Voley_Strategy.controller;

import com.duoc.Voley_Strategy.model.Estrategia;
import com.duoc.Voley_Strategy.repository.EstrategiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/estrategias")
@CrossOrigin(origins = "*")
public class EstrategiaController {

    @Autowired
    private EstrategiaRepository estrategiaRepository;

    // Listar todas las estrategias 
    @GetMapping
    public ResponseEntity<List<Estrategia>> obtenerTodas() {
        return ResponseEntity.ok(estrategiaRepository.findAll());
    }

    //  Crear una nueva estrategia de juego 
    @PostMapping
    public ResponseEntity<Estrategia> crearEstrategia(@RequestBody Estrategia estrategia) {
        Estrategia nuevaEstrategia = estrategiaRepository.save(estrategia);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaEstrategia);
    }
    // Eliminar una estrategia por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstrategia(@PathVariable Integer id) {
        if (!estrategiaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        estrategiaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    // Modificar el nombre de una estrategia por su ID
    @PutMapping("/{id}")
    public ResponseEntity<String> modificarNombre(@PathVariable Integer id, @RequestParam String nuevoNombre) {
        if (!estrategiaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        Estrategia estrategia = estrategiaRepository.findById(id).orElse(null);
        estrategia.setNombreEstrategia(nuevoNombre);
        estrategiaRepository.save(estrategia);
        return ResponseEntity.ok("Nombre de la estrategia actualizado correctamente a: " + nuevoNombre);
    }
}