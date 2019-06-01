package com.example.demo.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
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
import com.example.demo.Mapper.MapperComponentAlquilerImp;
import com.example.demo.Repo.AlquilerRepo;
import com.example.demo.Repo.ClienteRepo;
import com.example.demo.Service.RentalService;
import com.example.demo.dto.Client;
import com.example.demo.dto.Rental;
import com.example.demo.model.Alquiler;
import com.example.demo.model.Cliente;

@RestController
@RequestMapping("/alquiler")
public class AlquilerController {
	
	/*
	 * 
	 * {
    "id": null,
    "car": {
        "id": 1,
        "carPlate": "1123Bmw",
        "registrationYear": "2002"
    },
    "client": {
        "id": 21,
        "dni": "12345677",
        "name": "curro"
    },
    "price": 200,
    "startDate": "2002-01-01 00:00:00.0",
    "endDate": "2002-01-01 00:00:00.0"
}
	 */
	
	@Autowired
	private RentalService RentService;
	@Autowired 
	private MapperComponent<Rental, Alquiler> Mapper;
	
	@GetMapping
	public Page<Rental> todos(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam( value = "page", defaultValue = "0")int page, 
			@RequestParam(value = "size", defaultValue="10") int size){
		
		return RentService.buscaTodosPage(name, PageRequest.of(page, size)) ;		
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Rental> busca(@PathVariable("id")Integer id){
		return RentService.buscaPorId(id).
				map(Mapper::toDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());		 
	}
	
	@PutMapping
	public void usoPut(@RequestBody Rental car) throws ParseException
	{
		Optional<Alquiler> a=RentService.buscaPorId(car.getId());
		//si hay algo puedo modificar --> ok
		if(a.isPresent()) RentService.usaPutModifica(Mapper.toModel(car));
		else		{
			//si no hay nada no
		}		
	}
	
	@PostMapping
	public ResponseEntity<Rental> usoPost(@RequestBody Rental car) throws ParseException{
		
		if(car.getId()==null) return ResponseEntity.notFound().build();
		
		Optional<Alquiler> a=RentService.buscaPorId(car.getId());
		if(a.isPresent()) {return ResponseEntity.notFound().build();}		
		else  return RentService.usaPostCrea(Mapper.toModel(car))
				.map(Mapper::toDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());			
	}
	@DeleteMapping("/{id}")
	public void usoDelete(@PathVariable("id")Integer id)
	{
			RentService.usoDelete(id);
	}
	
}