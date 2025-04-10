package com.example.tallerSpringBoot.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
public class ZonaSocial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idZona;

    @Column(length = 50)
    private String nombre;

    @Column(length = 100)
    private String ubicacion;

    @Column(nullable = true)
    private int capacidad;

    @OneToMany(mappedBy = "idZona")
    @JsonIgnore
    private List<ReservaZona> reservaZonas;

    public ZonaSocial() {
    }

    public ZonaSocial(long idZona, String nombre, String ubicacion, int capacidad, List<ReservaZona> reservaZonas) {
        this.idZona = idZona;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
        this.reservaZonas = reservaZonas;
    }

    public long getIdZona() {
        return idZona;
    }

    public void setIdZona(long idZona) {
        this.idZona = idZona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<ReservaZona> getReservaZonas() {
        return reservaZonas;
    }

    public void setReservaZonas(List<ReservaZona> reservaZonas) {
        this.reservaZonas = reservaZonas;
    }
}
