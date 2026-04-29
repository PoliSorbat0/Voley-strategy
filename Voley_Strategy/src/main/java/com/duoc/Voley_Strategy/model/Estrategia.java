package com.duoc.Voley_Strategy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private int idEstrategia;
    
    @NotBlank
    private String nombreEstrategia;

    
    
}
