package com.example.demo.MapperService;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Rental;
import com.example.demo.model.Alquiler;

@Service
public class MapperServiceAlquilerImp implements MapperService<Rental,Alquiler>{

	@Override
	public Rental toDto(Alquiler model) {
		
		Rental c1 = new Rental();
		
		c1.setStartDate(model.getFechaInicioAlquiler().toString());
		c1.setEndDate(model.getFechaFinAlquiler().toString());
		c1.setId(model.getIdAlquiler());
		c1.setPrice(model.getPrecio());
		c1.setCar(model.getCocheAlquilado());
		c1.setClient(model.getClienteAlquilado());
		
		return c1;
		
	}

	@Override
	public Alquiler toModel(Rental mDto) {
		
		Alquiler c1 = new Alquiler();
		
		c1.setClienteAlquilado(mDto.getClient());
		c1.setCocheAlquilado(mDto.getCar());
		c1.setIdAlquiler(mDto.getId());
		c1.setPrecio(mDto.getPrice());
		c1.setFechaFinAlquiler(mDto.getEndDate());
		c1.setFechaInicioAlquiler(mDto.getStartDate());
		
		return c1;
	}

}
