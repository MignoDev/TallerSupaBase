package com.example.tallerSpringBoot.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ZonaSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idZona;

    @Column(length = 50)
    private String nombre;

    @Column(length = 100)
    private String ubicacion;

    private int capacidad;
}
