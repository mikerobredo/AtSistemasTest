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
import com.example.demo.Repo.CocheRepo;
import com.example.demo.dto.CocheDto;
import com.example.demo.model.Coche;


@RestController
@RequestMapping("/coche")
public class CocheController {
	
	@Autowired
	private CocheRepo cocheControlador;
	@Autowired
	private MapperService<CocheDto, Coche> servicioCoches;
	
	@GetMapping
	public List<CocheDto> todos()
	{
		//return cocheControlador.findAll();
		List<Coche> lc = cocheControlador.findAll();
		List<CocheDto> lcDto = new ArrayList<CocheDto>();
		for(Coche c: lc)
		{
			lcDto.add(servicioCoches.toDto(c));
		}
		return  lcDto;
		
	}
	
	@GetMapping("/{id}")
	public Coche busca(@PathVariable("id")String id)
	{	
		return cocheControlador.getOne(id);
	}
	@PutMapping
	public Coche usoPut(@RequestBody Coche car)
	{
		cocheControlador.save(car);
		return car;
	}
	@PostMapping
	public Coche usoPost(@RequestBody Coche car)
	{
		//devolver el elementoque tienes
		cocheControlador.save(car);
		return car;
	}
	@DeleteMapping("/{id}")
	public void usoDelete(@PathVariable("id")String id)
	{
		cocheControlador.deleteById(id);
	}
	
	
	

}

