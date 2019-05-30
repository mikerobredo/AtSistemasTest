package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Alquiler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idAlquiler;
	@Temporal(TemporalType.DATE)
	private Date fechaInicioAlquiler, fechaFinAlquiler;
	private Double precio;
	
	@ManyToOne
	private Coche cocheAlquilado;
	
	@ManyToOne 
	private Cliente clienteAlquilado;
	

}
