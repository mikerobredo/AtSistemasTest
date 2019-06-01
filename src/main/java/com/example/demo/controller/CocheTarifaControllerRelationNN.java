package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repo.CocheRepo;
import com.example.demo.Repo.TarifaRepo;
import com.example.demo.model.Coche;

@RestController
@RequestMapping("/coche/{id}/tarifa/{id2}")
public class CocheTarifaControllerRelationNN {
	
	@Autowired
	private CocheRepo cocheControlador;	
	@Autowired
	private TarifaRepo tarifaControlador;
	
	@GetMapping
	public void todos(@PathVariable("id")Integer id, @PathVariable("id2") Integer id2)
	{		
		Coche c1= cocheControlador.getOne(id);		
		c1.addTarifa(tarifaControlador.getOne(id2));		
		cocheControlador.save(c1);	
	}

}
