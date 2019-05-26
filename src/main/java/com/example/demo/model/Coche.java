package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Coche {
	public Coche() {}
	
	public Coche(String string, String string2, String string3, String string4) {
		this.matricula=string;
		this.color=string2;
		this.marca=string3;
		this.modelo=string4;
		
		// TODO Auto-generated constructor stub
	}
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
