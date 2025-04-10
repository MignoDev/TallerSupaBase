package com.example.tallerSpringBoot.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity

public class ReservaParqueadero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReserva;

    private LocalDate fecha;

    private LocalTime horaInicio;

    @Column(name = "id_propietario")
    private long idPropietario;

    @ManyToOne
    @JoinColumn(name = "id_propietario", insertable = false, updatable = false)
    @JsonIgnore
    private Propietario propietario;

    public ReservaParqueadero() {
    }

    public ReservaParqueadero(long idReserva, LocalDate fecha, LocalTime horaInicio, long idPropietario, Propietario propietario) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.idPropietario = idPropietario;
        this.propietario = propietario;
    }

    public long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(long idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public long getIdPropietario() {
        return idPropietario;
    }

    public Propietario getPropietario() {
        return propietario;
    }
}
