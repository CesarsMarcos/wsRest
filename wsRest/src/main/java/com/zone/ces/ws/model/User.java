package com.zone.ces.ws.model;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="usuario")

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="edad")
	private Integer edad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
