package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.Repo.CocheRepo;
import com.example.demo.Repo.TarifaRepo;
import com.example.demo.model.Coche;
import com.example.demo.model.Tarifa;

public class CarRentalRelationServiceImpl implements CarRentalRelationService{

	@Autowired
	private CocheRepo cocheControlador;	
	@Autowired
	private TarifaRepo tarifaControlador;
	
	@Override
	public void MakeRelationCarRental(Integer id, Integer id2) {
		
		Optional<Coche> c1= cocheControlador.findById(id);	
		Optional<Tarifa> t1 = tarifaControlador.findById(id2);
		if(c1.isPresent() && t1.isPresent())
		{			
			Coche cfinal= c1.get();
			cfinal.addTarifa(t1.get());			
			cocheControlador.save(cfinal);		
		}			
	}
}
