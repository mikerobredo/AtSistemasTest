package com.example.demo.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.MapperService.MapperService;
import com.example.demo.Repo.CocheRepo;
import com.example.demo.dto.Car;
import com.example.demo.model.Coche;

@RestController
@RequestMapping("/coche")
public class CocheController {
	/*
	 * 
	 * 	
	"id":"1",
   "carPlate":"1123Bmw",
	"registrationYear":"2002"
	*/
	@Autowired
	private CocheRepo cocheControlador;
	@Autowired
	private MapperService<Car, Coche> servicioCoches;
	
	@GetMapping
	public List<Car> todos()
	{
		List<Coche> lc = cocheControlador.findAll();
		List<Car> lcDto = new ArrayList<Car>();
		for(Coche c: lc)
		{
			lcDto.add(servicioCoches.toDto(c));
		}
		return  lcDto;		
	}
	
	@GetMapping("/{id}")
	public Car busca(@PathVariable("id")Integer id)
	{	
		Coche c1= cocheControlador.getOne(id);
		Car c2= servicioCoches.toDto(c1);
		return c2;
	}
	@PutMapping
	public Car usoPut(@RequestBody Car car) throws ParseException
	{
		cocheControlador.save(servicioCoches.toModel(car));		
		return car;
	}
	@PostMapping
	public Car usoPost(@RequestBody Car car) throws ParseException
	{
			
		return servicioCoches.toDto
				(cocheControlador.save
						(servicioCoches.toModel(car)));
	}
	@DeleteMapping("/{id}")
	public Car usoDelete(@PathVariable("id")Integer id)
	{
		Coche c1= cocheControlador.getOne(id);
		Car c2= servicioCoches.toDto(c1);
		cocheControlador.delete(cocheControlador.getOne(id));
		
		return c2;
	}
	
}