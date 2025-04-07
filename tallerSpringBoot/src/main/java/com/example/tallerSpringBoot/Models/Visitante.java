package com.example.tallerSpringBoot.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Visitante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVisitante;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String cedula;

    @Column(length = 50)
    private String telefono;

    @Column(length = 100)
    private String correo;

    //relacion
    private long idPropietario;
}
