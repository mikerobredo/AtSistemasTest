package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
	
	@Column(unique = true)
	private String carPlate;
	private String registrationYear;
	
	@OneToMany(mappedBy="cocheAlquilado")
	private List<Alquiler> alquileres= new ArrayList<Alquiler>();
	
	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
	private List<Tarifa> tarifas = new ArrayList<Tarifa>();
	
	//metodos para el control de la relaccion
	public void addTarifa(Tarifa tarifa) {
        tarifas.add(tarifa);
        tarifa.getCoches().add(this);
    }
 
    public void removeTarifa(Tarifa tarifa) {
        tarifas.remove(tarifa);
        tarifa.getCoches().remove(this);
    }
}
