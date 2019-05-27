package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MapperService.MapperService;
import com.example.demo.Repo.CocheRepo;
import com.example.demo.Repo.TarifaRepo;
import com.example.demo.dto.CocheDto;
import com.example.demo.dto.TarifaDto;
import com.example.demo.model.Coche;
import com.example.demo.model.Tarifa;

@RestController
@RequestMapping("/coche/{id}/tarifa/{id2}")
public class CocheTarifaControllerRelationNN {
	
	@Autowired
	private CocheRepo cocheControlador;
	@Autowired
	private MapperService<CocheDto, Coche> servicioCoches;
	@Autowired
	private TarifaRepo tarifaControlador;
	@Autowired
	private MapperService<TarifaDto, Tarifa> serviciotarifas;
	
	@GetMapping
	public void todos()
	{
		Coche c1= cocheControlador.getOne("9639bmv");
		Tarifa c2 = tarifaControlador.getOne(1);
		c1.setTarifa(c2);
		cocheControlador.save(c1);
	}

}
