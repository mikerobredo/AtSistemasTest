package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repo.CocheRepo;
import com.example.demo.Repo.TarifaRepo;
import com.example.demo.Service.CarRentalRelationService;
import com.example.demo.model.Coche;
import com.example.demo.model.Tarifa;

@RestController
@RequestMapping("/car/{id}/rate/{id2}")
public class CocheTarifaControllerRelationNN {
	
	@Autowired
	private CocheRepo cocheControlador;	
	@Autowired
	private TarifaRepo tarifaControlador;
	/*@Autowired
	private CarRentalRelationService relationService;
	*/
	@GetMapping
	public void todos(@PathVariable("id")Integer id, @PathVariable("id2") Integer id2)
	{		
	Optional<Coche> c1= cocheControlador.findById(id);	
	Optional<Tarifa> t1 = tarifaControlador.findById(id2);
	if(c1.isPresent() && t1.isPresent())
	{			
		Coche cfinal= c1.get();
		cfinal.addTarifa(t1.get());			
		cocheControlador.save(cfinal);		
	}
		//lo intente hacelo con servicio pero me daba un fallo en autowired requires que no me ha ido
		//relationService.MakeRelationCarRental(id, id2);
	}

}
