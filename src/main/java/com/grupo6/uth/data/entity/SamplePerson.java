package com.grupo6.uth.data.entity;

import jakarta.persistence.Entity;

@Entity
public class SamplePerson extends AbstractEntity {

    private String Nombre;
    private String Apellido;
    private String identidad;
    private String Telefono;
    
    
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getidentidad() {
		return identidad;
	}
	public void setIdentidad(String identidad) {
		identidad = identidad;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
    
    


}
