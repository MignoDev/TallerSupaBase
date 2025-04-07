package com.example.tallerSpringBoot.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ReservaParqueadero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReserva;

    private LocalDate fecha;

    private LocalTime horaInicio;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private long idPropietario;
}
