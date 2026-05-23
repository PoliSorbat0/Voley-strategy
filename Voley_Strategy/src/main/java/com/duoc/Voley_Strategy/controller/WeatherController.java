package com.duoc.Voley_Strategy.controller;

import com.duoc.Voley_Strategy.DTO.WeatherDTO;
import com.duoc.Voley_Strategy.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clima")
@CrossOrigin(origins = "*")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    // Obtener los datos del clima mapeados directamente al WeatherDTO
    @GetMapping
    public ResponseEntity<WeatherDTO> obtenerClima() {
        WeatherDTO clima = weatherService.obtenerClima(-33.45, -70.65);
        return ResponseEntity.ok(clima);
    }
}