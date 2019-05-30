package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Calendar;
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
import com.example.demo.Repo.TarifaRepo;
import com.example.demo.dto.TarifaDto;
import com.example.demo.model.Tarifa;

@RestController
@RequestMapping("/tarifa")
public class TarifaController {
	
	@Autowired
	private TarifaRepo tarifaControlador;
	@Autowired
	private MapperService<TarifaDto, Tarifa> serviciotarifas;
	
	@GetMapping
	public List<TarifaDto> todos()
	{
		/**crear una entidad desde dentro para ver el json que muestra y usarlo
		 * 
		Tarifa t= new Tarifa();
		Calendar c1 = Calendar.getInstance(),c2= Calendar.getInstance();
		t.setFechaInicio(c1);
		t.setFechaFin(c2);
		t.setPrecio((float)20.00);
		tarifaControlador.save(t);
		*/
		
		List<Tarifa> lc = tarifaControlador.findAll();
		List<TarifaDto> lcDto = new ArrayList<TarifaDto>();
		for(Tarifa c: lc)
		{
			lcDto.add(serviciotarifas.toDto(c));
		}
		return  lcDto;		
	}
	
	@GetMapping("/{id}")
	public TarifaDto busca(@PathVariable("id")Integer id)
	{	
		Tarifa c1= tarifaControlador.getOne(id);
		//c1.
		TarifaDto c2= serviciotarifas.toDto(c1);
		return c2;
	}
	@PutMapping
	public TarifaDto usoPut(@RequestBody TarifaDto car)
	{
		tarifaControlador.save(serviciotarifas.toModel(car));		
		return car;
	}
	@PostMapping
	public TarifaDto usoPost(@RequestBody TarifaDto car)
	{
		tarifaControlador.save(serviciotarifas.toModel(car));		
		return car;
	}
	@DeleteMapping("/{id}")
	public TarifaDto usoDelete(@PathVariable("id")Integer id)
	{
		Tarifa c1= tarifaControlador.getOne(id);
		TarifaDto c2= serviciotarifas.toDto(c1);
		tarifaControlador.delete(tarifaControlador.getOne(id));
		
		return c2;
	}
	
}