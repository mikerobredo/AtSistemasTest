package com.example.demo.MapperService;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ClienteDto;
import com.example.demo.model.Cliente;

@Service
public class MapperServiceClienteImp implements MapperService<ClienteDto,Cliente>{

	@Override
	public ClienteDto toDto(Cliente model) {
		
		ClienteDto c1 = new ClienteDto();
		
		c1.setDni(model.getDni());
		c1.setNombre(model.getNombre());
		c1.setApellido(model.getApellido());
		c1.setIdPersona(model.getIdPersona());
		
		return c1;
		
	}

	@Override
	public Cliente toModel(ClienteDto mDto) {
		
		Cliente c1 = new Cliente();
		
		c1.setDni(mDto.getDni());
		c1.setNombre(mDto.getNombre());
		c1.setApellido(mDto.getApellido());
		c1.setIdPersona(mDto.getIdPersona());
				
		return c1;
	}

}