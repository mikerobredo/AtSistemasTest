package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Cliente {
	public Cliente(){}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPersona;
	
	private String nombre;
	//fixme no existe la relccion
	//@Column(unique=true)
	private String dni;
	
	@OneToMany(mappedBy="clienteAlquilado")
	private List<Alquiler> alquileres = new ArrayList<Alquiler>();
	

}
