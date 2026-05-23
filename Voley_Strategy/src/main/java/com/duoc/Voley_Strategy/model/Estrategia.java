package com.duoc.Voley_Strategy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "Estrategias")
public class Estrategia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstrategia;

    @NotBlank
    private String descripcionEstrategia;

    @NotBlank
    private String nombreEstrategia;

    @ManyToOne(fetch = FetchType.LAZY)
    private Equipo equipo;
    
}
