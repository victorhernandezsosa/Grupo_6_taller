package com.grupo6.uth.data.entity;

import jakarta.persistence.Entity;

@Entity
public class Empleado extends AbstractEntity {

    private String identidad;
    private String nombre;
    private String apellido;
    private Integer sueldo;

    public String getIdentidad() {
        return identidad;
    }
    public void setIdentidad(String identidad) {
        this.identidad = identidad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Integer getSueldo() {
        return sueldo;
    }
    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

}
