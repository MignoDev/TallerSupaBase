package com.example.tallerSpringBoot.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class ReservaZona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReserva;

    private LocalDate fecha;

    private LocalTime horaInicio;

    @ManyToOne
    @JoinColumn(name = "id_zona")
    private ZonaSocial idZona;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private Propietario idPropietario;

    public ReservaZona() {
    }

    public ReservaZona(long idReserva, LocalDate fecha, LocalTime horaInicio, ZonaSocial idZona, Propietario idPropietario) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.idZona = idZona;
        this.idPropietario = idPropietario;
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

    public ZonaSocial getIdZona() {
        return idZona;
    }

    public void setIdZona(ZonaSocial idZona) {
        this.idZona = idZona;
    }

    public Propietario getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Propietario idPropietario) {
        this.idPropietario = idPropietario;
    }
}
