package com.zone.ces.ws.model;

import javax.persistence.Entity;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="usuario")

public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id_usuario")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="edad")
	private Integer edad;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	
	
	
}
