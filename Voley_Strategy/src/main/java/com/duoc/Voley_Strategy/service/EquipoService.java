package com.duoc.Voley_Strategy.service;

import com.duoc.Voley_Strategy.model.Equipo;
import com.duoc.Voley_Strategy.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public Equipo registrarEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public List<Equipo> listarTodos() {
        return equipoRepository.findAll();
    }

    public Equipo seleccionarEquipo(Integer id) {
        return equipoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado con ID: " + id));
    }

    public void modificarNombre(Integer id, String nuevoNombre) {
        Equipo equipo = seleccionarEquipo(id);
        equipo.setNombreEquipo(nuevoNombre);
        equipoRepository.save(equipo);
    }
}
