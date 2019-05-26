package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Coche {
	@Id	
	private String matricula;
	private String color;
	private String marca;
	private String modelo;
	
	@OneToMany
	private List<Alquiler> alquileres= new ArrayList<Alquiler>();
	@ManyToMany
	private Set<Tarifa> tarifas = new HashSet<>();
	
}
