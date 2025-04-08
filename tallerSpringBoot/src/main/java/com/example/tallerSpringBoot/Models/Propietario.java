package com.example.tallerSpringBoot.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
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
    @JsonIgnore
    private List<ReservaParqueadero> reservaParqueaderos;

    @OneToMany(mappedBy = "idPropietario")
    @JsonIgnore
    private List<ReservaZona> reservaZonas;

    @OneToMany(mappedBy = "idPropietario")
    @JsonIgnore
    private List<Visitante> visitantes;

    public Propietario() {
    }

    public Propietario(long idPropietario, String nombre, String cedula, LocalDate fechaVisita, LocalTime horaEntrada, List<ReservaParqueadero> reservaParqueaderos, List<ReservaZona> reservaZonas, List<Visitante> visitantes) {
        this.idPropietario = idPropietario;
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaVisita = fechaVisita;
        this.horaEntrada = horaEntrada;
        this.reservaParqueaderos = reservaParqueaderos;
        this.reservaZonas = reservaZonas;
        this.visitantes = visitantes;
    }

    public long getIdPropietario() {
        return idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public LocalDate getFechaVisita() {
        return fechaVisita;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public List<ReservaParqueadero> getReservaParqueaderos() {
        return reservaParqueaderos;
    }

    public List<ReservaZona> getReservaZonas() {
        return reservaZonas;
    }

    public List<Visitante> getVisitantes() {
        return visitantes;
    }
}
