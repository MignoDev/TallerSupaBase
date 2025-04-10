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

    @Column(name = "id_zona")
    private long idZona;

    @Column(name = "id_propietario")
    private long idPropietario;

    @ManyToOne
    @JoinColumn(name = "id_zona", insertable = false, updatable = false)
    private ZonaSocial zona;

    @ManyToOne
    @JoinColumn(name = "id_propietario", insertable = false, updatable = false)
    private Propietario propietario;

    public ReservaZona() {
    }

    public ReservaZona(long idReserva, LocalDate fecha, LocalTime horaInicio, long idZona, long idPropietario, ZonaSocial zona, Propietario propietario) {
        this.idReserva = idReserva;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.idZona = idZona;
        this.idPropietario = idPropietario;
        this.zona = zona;
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

    public long getIdZona() {
        return idZona;
    }

    public void setIdZona(long idZona) {
        this.idZona = idZona;
    }

    public long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public ZonaSocial getZona() {
        return zona;
    }

    public void setZona(ZonaSocial zona) {
        this.zona = zona;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}
