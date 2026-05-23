package com.duoc.Voley_Strategy.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name= "jugadores")
public class Jugador {
    //ATRIBUTOS
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJugador;
    //Nombre del jugador
    @NotBlank
    private String nombre;
    //Apellido del jugador
    @NotBlank
    private String apellido;

    //Altura del jugador
    @NotNull
    private Integer altura;

    //Años que juega
    @NotNull
    private Integer anosJugando;

    //Zapatillas del jugador
    @NotBlank
    private String marcaZapatillas;
    @NotBlank
    private String colorZapatillas;

    //Rol del jugador
    @NotBlank
    private String rol; //Armador/Central/Punta (L/C)/Opuesto/Libero(?)
    
    //Posición dentro de la cancha
    @NotNull
    private Integer posicion; // Posición en cancha (1,2,3,4,5,6)

    @ManyToOne(fetch = FetchType.LAZY)
    private Equipo equipo; 

}
