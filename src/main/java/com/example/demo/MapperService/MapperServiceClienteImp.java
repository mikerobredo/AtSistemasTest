package com.example.demo.MapperService;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Client;
import com.example.demo.model.Cliente;

@Component
public class MapperServiceClienteImp implements MapperService<Client,Cliente>{

	@Override
	public Client toDto(Cliente model) {
		
		Client c1 = new Client();
		
		c1.setDni(model.getDni());
		c1.setName(model.getNombre());		
		c1.setId(model.getIdPersona());
		
		return c1;		
	}

	@Override
	public Cliente toModel(Client mDto) {
		
		Cliente c1 = new Cliente();
		
		c1.setDni(mDto.getDni());
		c1.setNombre(mDto.getName());		
		c1.setIdPersona(mDto.getId());
		
		return c1;
	}

}