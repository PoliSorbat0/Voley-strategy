package com.duoc.Voley_Strategy.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            // Desactivamos CSRF porque para APIs REST con JWT no se necesita
            .csrf(csrf -> csrf.disable()) 
            
            // Configuramos los permisos de las rutas
            .authorizeHttpRequests(auth -> auth
                // Permite acceso total y público a la documentación de Swagger
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                
                // Cualquier otra ruta va a pedir estar autenticado
                .anyRequest().authenticated()
            )
            
            // Indicamos que no guardaremos sesión en el servidor (típico de JWT)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            
            .build();
    }
}