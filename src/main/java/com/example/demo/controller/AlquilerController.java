package com.example.demo.controller;

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
import com.example.demo.Repo.AlquilerRepo;
import com.example.demo.Repo.ClienteRepo;
import com.example.demo.dto.Rental;
import com.example.demo.model.Alquiler;

@RestController
@RequestMapping("/alquiler")
public class AlquilerController {
	
	@Autowired
	private AlquilerRepo alquilerControlador;
	@Autowired
	private MapperService<Rental, Alquiler> servicioAlquilers;
	@Autowired
	private ClienteRepo clienteControlador;
	
	@GetMapping
	public List<Rental> todos()
	{
		List<Alquiler> lc = alquilerControlador.findAll();
		List<Rental> lcDto = new ArrayList<Rental>();
		for(Alquiler c: lc)
		{
			lcDto.add(servicioAlquilers.toDto(c));
		}
		return  lcDto;		
	}
	
	@GetMapping("/{id}")
	public Rental busca(@PathVariable("id")Integer id)
	{	
		Alquiler c1= alquilerControlador.getOne(id);
		c1.setClienteAlquilado(clienteControlador.getOne(1));
		alquilerControlador.save(c1);
		Rental c2= servicioAlquilers.toDto(c1);
		return c2;
	}
	@PutMapping
	public Rental usoPut(@RequestBody Rental car)
	{
		
		alquilerControlador.save(servicioAlquilers.toModel(car));		
		return car;
	}
	@PostMapping
	public Rental usoPost(@RequestBody Rental car)
	{
		alquilerControlador.save(servicioAlquilers.toModel(car));		
		return car;
	}
	@DeleteMapping("/{id}")
	public Rental usoDelete(@PathVariable("id")Integer id)
	{
		Alquiler c1= alquilerControlador.getOne(id);
		Rental c2= servicioAlquilers.toDto(c1);
		alquilerControlador.delete(alquilerControlador.getOne(id));
		
		return c2;
	}
	
}