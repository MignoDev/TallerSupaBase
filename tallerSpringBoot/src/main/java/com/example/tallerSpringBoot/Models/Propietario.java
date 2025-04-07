package com.example.tallerSpringBoot.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPropietario;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String cedula;

    private LocalDate fechaVisita;

    private LocalTime horaEntrada;

    @OneToMany(mappedBy = "idPropietario")
    private List<ReservaParqueadero> reservaParqueaderos;

    @OneToMany(mappedBy = "idPropietario")
    private List<ReservaZona> reservaZonas;

    @OneToMany(mappedBy = "idPropietario")
    private List<Visitante> visitantes;
}
