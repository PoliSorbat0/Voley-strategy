package com.duoc.Voley_Strategy.service;

import com.duoc.Voley_Strategy.model.Equipo;
import com.duoc.Voley_Strategy.model.Estrategia;
import com.duoc.Voley_Strategy.repository.EstrategiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstrategiaService {

    @Autowired
    private EstrategiaRepository estrategiaRepository;

    // Registrar una nueva estrategia de juego
    public Estrategia registrarEstrategia(Estrategia estrategia) {
        return estrategiaRepository.save(estrategia);
    }

    // Listar todas las estrategias
    public List<Estrategia> listarTodas() {
        return estrategiaRepository.findAll();
    }

    // Seleccionar una estrategia por su ID
    public Estrategia seleccionarEstrategia(Integer id) {
        return estrategiaRepository.findById(id).orElse(null);
    }
    // Eliminar una estrategia por su ID
    public void eliminarEstrategia(Integer id) {
        estrategiaRepository.deleteById(id);
    }
    // Modificar el nombre de una estrategia por su ID
        public void modificarNombre(Integer id, String nuevoNombre) {
        Estrategia estrategia = seleccionarEstrategia(id);
        estrategia.setNombreEstrategia(nuevoNombre);
        estrategiaRepository.save(estrategia);
    }
}