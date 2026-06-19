package com.duoc.Voley_Strategy.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JugadorCanchaDTO {
    public JugadorCanchaDTO(Object rol2, Object posicion2) {
        //TODO Auto-generated constructor stub
    }

    //Rol del jugador
    private String rol; //Armador/Central/Punta (L/C)/Opuesto/Libero(?)
    
    //Posición dentro de la cancha
    private Integer posicion; // Posición en cancha (1,2,3,4,5,6)
}
