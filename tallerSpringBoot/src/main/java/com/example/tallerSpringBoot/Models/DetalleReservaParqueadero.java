package com.example.tallerSpringBoot.Models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DetalleReservaParqueadero {

    private long idReserva;

    private long idParqueadero;
}
