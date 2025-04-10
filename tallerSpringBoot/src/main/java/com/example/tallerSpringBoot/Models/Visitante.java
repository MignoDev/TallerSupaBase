package com.example.tallerSpringBoot.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

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

    @Column(name = "id_propietario")
    private long idPropietario;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_propietario", insertable = false, updatable = false)
    private Propietario propietario;

    public Visitante() {
    }

    public Visitante(long idVisitante, String nombre, String cedula, String telefono, String correo, long idPropietario, Propietario propietario) {
        this.idVisitante = idVisitante;
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo = correo;
        this.idPropietario = idPropietario;
        this.propietario = propietario;
    }

    public long getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(long idVisitante) {
        this.idVisitante = idVisitante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
}
