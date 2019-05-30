package com.example.demo.model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tarifa {
	public Tarifa() {}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idTarifa;
	
	private Double precio;
	@Temporal(TemporalType.DATE)
	private Date fechaInicio,fechaFin;
	
	@ManyToMany(mappedBy="tarifas")
	private Set<Coche> coches = new HashSet<>();
	

}
