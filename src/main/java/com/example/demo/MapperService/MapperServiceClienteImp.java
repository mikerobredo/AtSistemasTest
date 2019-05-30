package com.example.demo.MapperService;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Client;
import com.example.demo.model.Cliente;

@Service
public class MapperServiceClienteImp implements MapperService<Client,Cliente>{

	@Override
	public Client toDto(Cliente model) {
		
		Client c1 = new Client();
		
		c1.setDni(model.getDni());
		c1.setNombre(model.getNombre());
		c1.setApellido(model.getApellido());
		c1.setIdPersona(model.getIdPersona());
		
		return c1;
		
	}

	@Override
	public Cliente toModel(Client mDto) {
		
		Cliente c1 = new Cliente();
		
		c1.setDni(mDto.getDni());
		c1.setNombre(mDto.getNombre());
		c1.setApellido(mDto.getApellido());
		c1.setIdPersona(mDto.getIdPersona());
				
		return c1;
	}

}