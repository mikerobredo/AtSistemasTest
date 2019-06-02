package com.example.demo.controller;

import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mapper.MapperComponent;
import com.example.demo.Service.RateService;
import com.example.demo.dto.Rate;
import com.example.demo.model.Tarifa;

@RestController
@RequestMapping("/rate")
public class TarifaController {
	/*
	 * 
	"id":"1",
	"price":"112",
	"startDate":"2002-01-01 00:00:00.0",
	"endDate":"2002-01-01 00:00:00.0"
	 */
	@Autowired
	private RateService RateService;
	@Autowired 
	private MapperComponent<Rate, Tarifa> Mapper;
	
	
	@GetMapping
	public Page<Rate> todos(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam( value = "page", defaultValue = "0")int page, 
			@RequestParam(value = "size", defaultValue="10") int size){
		
		return RateService.buscaTodosPage(name, PageRequest.of(page, size)) ;		
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Rate> busca(@PathVariable("id")Integer id){
		return RateService.buscaPorId(id).
				map(Mapper::toDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());		 
	}
	
	@PutMapping
	public void usoPut(@RequestBody Rate car) throws ParseException{
		Optional<Tarifa> a=RateService.buscaPorId(car.getId());
		
		//si hay algo puedo modificar --> ok
		if(a.isPresent()) RateService.usaPutModifica(Mapper.toModel(car));
		else		{
			//si no hay nada no
		}		
	}
	
	@PostMapping
	public ResponseEntity<Rate> usoPost(@RequestBody Rate car) throws ParseException{
		/*
		if(car.getId()==null) return ResponseEntity.notFound().build();
		
		Optional<Tarifa> a=RateService.buscaPorId(car.getId());
		if(a.isPresent())	{return ResponseEntity.notFound().build();}	
		
		else 	*/
			return RateService.usaPostCrea(Mapper.toModel(car))
				.map(Mapper::toDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());			
	}
	
	@DeleteMapping("/{id}")
	public void usoDelete(@PathVariable("id")Integer id){
			RateService.usoDelete(id);
	}
}