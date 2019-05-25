package com.example.demo.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Tarifa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idTarifa;
	private Float precio;
	@Temporal(TemporalType.DATE)
	private Calendar fechaInicio,fechaFin;
	
	@ManyToMany
	private Set<Coche> coches = new HashSet<>();
	

}
