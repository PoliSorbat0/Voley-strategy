package com.duoc.Voley_Strategy.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * DTO que mapea la respuesta de la Open-Meteo API.
 * Endpoint: GET https://api.open-meteo.com/v1/forecast?latitude=...&longitude=...&current_weather=true
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDTO {

    @JsonProperty("current_weather")
    private CurrentWeather currentWeather;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CurrentWeather {
        //Saber la temperatura actual
        private Double temperature;
        //Saber la velocidad del viento
        private Double windspeed;
        //Saber la dirección del viento
        private Double winddirection;
        //Saber si es de dia o de noche
        private Integer is_day;
    }
}