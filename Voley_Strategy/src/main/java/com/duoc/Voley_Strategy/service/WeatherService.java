package com.duoc.Voley_Strategy.service;

import com.duoc.Voley_Strategy.DTO.WeatherDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {

    // Inicializamos el cliente directamente apuntando a la API de Open-Meteo
    private final WebClient weatherWebClient = WebClient.create("https://api.open-meteo.com");

    /**
     * Consulta el clima actual para las coordenadas dadas usando Open-Meteo.
     * La API es pública, gratuita y no requiere API Key.
     *
     * @param latitude  latitud (ej: -33.45 para Santiago)
     * @param longitude longitud (ej: -70.65 para Santiago)
     * @return WeatherDTO con temperatura, viento y más datos actuales
     */
    public WeatherDTO obtenerClima(double latitude, double longitude) {
        return weatherWebClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/forecast")
                        .queryParam("latitude", latitude)
                        .queryParam("longitude", longitude)
                        .queryParam("current_weather", true)
                        .build())
                .retrieve()
                .bodyToMono(WeatherDTO.class)
                .block();
    }
}