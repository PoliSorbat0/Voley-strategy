package com.duoc.Voley_Strategy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Errores de validación → 400 Bad Request
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationErrors(MethodArgumentNotValidException ex) {


        StringBuilder detalle = new StringBuilder();
        for (FieldError campo : ex.getBindingResult().getFieldErrors()) {
            detalle.append(campo.getField())           // nombre del campo (ej: "nombre")
                   .append(": ")
                   .append(campo.getDefaultMessage())  // mensaje de la anotación
                   .append(", ");
        }

        ApiError error = new ApiError(400, "Error de validación", detalle.toString());
        return ResponseEntity.badRequest().body(error);
    }

    //No se encuentra un Jugador o Equipo por ID → 404 Not Found
    
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiError> handleNotFoundError(NoSuchElementException ex) {
        ApiError error = new ApiError(404, "Recurso no encontrado", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    // Cualquier otra excepción  → 500 Internal Server Error
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericError(Exception ex) {
        ApiError error = new ApiError(500, "Error interno del servidor", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    //API EXTERNA 
    @org.springframework.web.bind.annotation.ExceptionHandler(org.springframework.web.reactive.function.client.WebClientResponseException.class)
    public ResponseEntity<ApiError> handleWebClientError(org.springframework.web.reactive.function.client.WebClientResponseException ex) {
        if (ex.getStatusCode().value() == 404) {
            ApiError error = new ApiError(404, "Ciudad o ubicación no encontrada en el servicio del clima", ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        ApiError error = new ApiError(502, "Error al consultar la API externa del clima", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(error);
    }
}