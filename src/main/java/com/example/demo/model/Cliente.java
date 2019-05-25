package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPersona;
	private String nombre;
	private String apellido;
	private String dni;
	
	@OneToMany
	private List<Alquiler> alquileres = new ArrayList<Alquiler>();
	

}
