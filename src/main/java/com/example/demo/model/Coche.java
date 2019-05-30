package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Coche {
	public Coche() {}
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String carPlate;
	private String registrationYear;
	
	@OneToMany(mappedBy="cocheAlquilado")
	private List<Alquiler> alquileres= new ArrayList<Alquiler>();
	@ManyToMany
	private Set<Tarifa> tarifas = new HashSet<>();
	
	
	
}
