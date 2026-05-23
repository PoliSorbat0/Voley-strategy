package com.duoc.Voley_Strategy.service;

import com.duoc.Voley_Strategy.model.Jugador;
import com.duoc.Voley_Strategy.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    // Registrar un nuevo jugador
    public Jugador registrarJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    // Listar todos los jugadores
    public List<Jugador> listarTodos() {
        return jugadorRepository.findAll();
    }

    // Seleccionar un jugador por su ID
    public Jugador seleccionarJugador(Integer id) {
        return jugadorRepository.findById(id).orElse(null);
    }
    //modificar nombre de un jugador por su ID
    public void modificarNombre(Integer id, String nuevoNombre) {
        Jugador jugador = seleccionarJugador(id);
        jugador.setNombre(nuevoNombre);
        jugadorRepository.save(jugador);
    }
    // Eliminar un jugador por su ID
    public void eliminarJugador(Integer id) {
        jugadorRepository.deleteById(id);
    }
}