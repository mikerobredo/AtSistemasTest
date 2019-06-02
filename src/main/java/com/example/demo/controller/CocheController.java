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
import com.example.demo.Service.CarService;
import com.example.demo.dto.Car;
import com.example.demo.model.Coche;

@RestController
@RequestMapping("/car")
public class CocheController {
	/*
	 * 
	 * 	
	"id":"1",
   "carPlate":"1123Bmw",
	"registrationYear":"2002"
	*/
	@Autowired
	private CarService CarService;
	@Autowired 
	private MapperComponent<Car, Coche> Mapper;
	
	
	@GetMapping
	public Page<Car> todos(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam( value = "page", defaultValue = "0")int page, 
			@RequestParam(value = "size", defaultValue="10") int size){
		
		return CarService.buscaTodosPage(name, PageRequest.of(page, size)) ;		
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Car> busca(@PathVariable("id")Integer id){
		return CarService.buscaPorId(id).
				map(Mapper::toDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());		 
	}
	
	@PutMapping
	public void usoPut(@RequestBody Car car) throws ParseException{
		Optional<Coche> a=CarService.buscaPorId(car.getId());
		
		if(a.isPresent()) CarService.usaPutModifica(Mapper.toModel(car));
		else		{
			//si no hay nada no
		}		
	}
	
	@PostMapping
	public ResponseEntity<Car> usoPost(@RequestBody Car car) throws ParseException{
		//si lo dejo me llega "" y no crea si lo quito tengo que meter un numero mayor al id de turno, no se que seria mejor supingo qu quitarlo
		
		/*
		if(car.getId()==null) return ResponseEntity.notFound().build();
		
		Optional<Coche> a=CarService.buscaPorId(car.getId());
		if(a.isPresent())	{return ResponseEntity.notFound().build();}		
		else 	
		*/
			return CarService.usaPostCrea(Mapper.toModel(car))
				.map(Mapper::toDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());			
	}
	
	@DeleteMapping("/{id}")
	public void usoDelete(@PathVariable("id")Integer id){
			CarService.usoDelete(id);
	}
}