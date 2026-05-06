package com.duoc.Voley_Strategy.controller;

import com.duoc.Voley_Strategy.model.Equipo;
import com.duoc.Voley_Strategy.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@CrossOrigin(origins = "*") 
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @PostMapping
    public Equipo crear(@RequestBody Equipo equipo) {
        return equipoService.registrarEquipo(equipo);
    }

    @GetMapping
    public List<Equipo> obtenerTodos() {
        return equipoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Equipo obtenerPorId(@PathVariable Integer id) {
        return equipoService.seleccionarEquipo(id);
    }

    // Cambié RequestBody por RequestParam para evitar errores comunes con strings
    @PutMapping("/{id}")
    public String renombrar(@PathVariable Integer id, @RequestParam String nuevoNombre) {
        equipoService.modificarNombre(id, nuevoNombre);
        return "Nombre actualizado correctamente a: " + nuevoNombre;
    }
}
