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
import com.example.demo.Service.ClientService;
import com.example.demo.dto.Client;
import com.example.demo.model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	/*
	 *  "id": 21,
        "dni": "12345677",
        "name": "curro"
	 */
	
	@Autowired
	private ClientService ClientService;
	@Autowired 
	private MapperComponent<Client, Cliente> Mapper;
	
	
	@GetMapping
	public Page<Client> todos(
			@RequestParam(value = "name", required = false) String name,
			@RequestParam( value = "page", defaultValue = "0")int page, 
			@RequestParam(value = "size", defaultValue="10") int size){
		
		return ClientService.buscaTodosPage(name, PageRequest.of(page, size)) ;		
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> busca(@PathVariable("id")Integer id){
		return ClientService.buscaPorId(id).
				map(Mapper::toDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());		 
	}
	
	@PutMapping
	public void usoPut(@RequestBody Client car) throws ParseException{
		Optional<Cliente> a=ClientService.buscaPorId(car.getId());
		
		//si hay algo puedo modificar --> ok
		if(a.isPresent()) ClientService.usaPutModifica(Mapper.toModel(car));
		else		{
			//si no hay nada no
		}		
	}
	
	@PostMapping
	public ResponseEntity<Client> usoPost(@RequestBody Client car) throws ParseException{
		
		if(car.getId()==null) return ResponseEntity.notFound().build();
		
		Optional<Cliente> a=ClientService.buscaPorId(car.getId());
		if(a.isPresent())	{return ResponseEntity.notFound().build();}		
		else 	return ClientService.usaPostCrea(Mapper.toModel(car))
				.map(Mapper::toDto)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());			
	}
	
	@DeleteMapping("/{id}")
	public void usoDelete(@PathVariable("id")Integer id){
			ClientService.usoDelete(id);
	}
	
	
}