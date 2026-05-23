package com.duoc.Voley_Strategy.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "Equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipo;

    @NotBlank
    private String nombreEquipo;

    //Colores euqipo
    @NotBlank
    private String colorPrimario;
    @NotBlank
    private String colorSecundario;

    //Fundación del equipo
    @NotBlank
    private String fechaFundacion;

    @NotNull
    private boolean duenoPunto;

    
    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude // Evita bucle infinito en consola
    private List<Jugador> jugadores; 

    
    @ManyToMany(fetch = FetchType.LAZY)
    @ToString.Exclude // Evita bucle infinito en consola
    private List<Estrategia> estrategias;

}