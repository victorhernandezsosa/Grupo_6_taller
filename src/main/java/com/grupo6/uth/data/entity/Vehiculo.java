package com.grupo6.uth.data.entity;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Vehiculo extends AbstractEntity {

    private String marca;
    private String modelo;
    private String placa;
    private LocalDate fechaentrada;
    private LocalDate fechasalida;
    private String servicio;
    private Integer costo;

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public LocalDate getFechaentrada() {
        return fechaentrada;
    }
    public void setFechaentrada(LocalDate fechaentrada) {
        this.fechaentrada = fechaentrada;
    }
    public LocalDate getFechasalida() {
        return fechasalida;
    }
    public void setFechasalida(LocalDate fechasalida) {
        this.fechasalida = fechasalida;
    }
    public String getServicio() {
        return servicio;
    }
    public void setServicio(String servicio) {
        this.servicio = servicio;
    }
    public Integer getCosto() {
        return costo;
    }
    public void setCosto(Integer costo) {
        this.costo = costo;
    }

}
