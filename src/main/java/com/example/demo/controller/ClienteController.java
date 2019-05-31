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
import com.example.demo.Repo.ClienteRepo;
import com.example.demo.dto.Client;
import com.example.demo.model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepo clienteControlador;
	@Autowired
	private MapperService<Client, Cliente> servicioClientes;
	
	@GetMapping
	public List<Client> todos()
	{
		List<Cliente> lc = clienteControlador.findAll();
		List<Client> lcDto = new ArrayList<Client>();
		for(Cliente c: lc)
		{
			lcDto.add(servicioClientes.toDto(c));
		}
		return  lcDto;		
	}
	
	@GetMapping("/{id}")
	public Client busca(@PathVariable("id")Integer id)
	{	
		Cliente c1= clienteControlador.getOne(id);
		Client c2= servicioClientes.toDto(c1);
		return c2;
	}
	@PutMapping
	public Client usoPut(@RequestBody Client car) throws ParseException
	{
		clienteControlador.save(servicioClientes.toModel(car));		
		return car;
	}
	@PostMapping
	public Client usoPost(@RequestBody Client car) throws ParseException
	{
		clienteControlador.save(servicioClientes.toModel(car));		
		return car;
	}
	@DeleteMapping("/{id}")
	public Client usoDelete(@PathVariable("id")Integer id)
	{
		Cliente c1= clienteControlador.getOne(id);
		Client c2= servicioClientes.toDto(c1);
		clienteControlador.delete(clienteControlador.getOne(id));
		
		return c2;
	}
	
}