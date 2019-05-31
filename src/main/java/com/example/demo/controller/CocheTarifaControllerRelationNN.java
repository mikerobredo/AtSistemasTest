package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MapperService.MapperService;
import com.example.demo.Repo.CocheRepo;
import com.example.demo.Repo.TarifaRepo;
import com.example.demo.dto.Car;
import com.example.demo.dto.Rate;
import com.example.demo.model.Coche;
import com.example.demo.model.Tarifa;

@RestController
@RequestMapping("/coche/{id}/tarifa/{id2}")
public class CocheTarifaControllerRelationNN {
	
	@Autowired
	private CocheRepo cocheControlador;
	@Autowired
	private MapperService<Car, Coche> servicioCoches;
	@Autowired
	private TarifaRepo tarifaControlador;
	@Autowired
	private MapperService<Rate, Tarifa> serviciotarifas;
	
	@GetMapping
	public void todos(@PathVariable("id")Integer id, @PathVariable("id2") Integer id2)
	{
		System.out.print(id);
		System.out.print(id2);
		
		Coche c1= cocheControlador.getOne(id);
		Tarifa c2 = tarifaControlador.getOne(id2);
		Set<Tarifa> s1 =c1.getTarifas();
		s1.add(c2);
		c1.setTarifas(s1);
		cocheControlador.save(c1);
		
	}

}
