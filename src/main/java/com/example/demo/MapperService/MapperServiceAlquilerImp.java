package com.example.demo.MapperService;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Rental;
import com.example.demo.model.Alquiler;

@Service
public class MapperServiceAlquilerImp implements MapperService<Rental,Alquiler>{

	@Override
	public Rental toDto(Alquiler model) {
		
		Rental c1 = new Rental();
		
		c1.setFechaInicioAlquiler(model.getFechaInicioAlquiler());
		c1.setFechaFinAlquiler(model.getFechaFinAlquiler());
		c1.setIdAlquiler(model.getIdAlquiler());
		c1.setPrecioAlquiler(model.getPrecio());
		
		return c1;
		
	}

	@Override
	public Alquiler toModel(Rental mDto) {
		
		Alquiler c1 = new Alquiler();
		
		c1.setFechaInicioAlquiler(mDto.getFechaInicioAlquiler());
		c1.setFechaFinAlquiler(mDto.getFechaFinAlquiler());
		c1.setIdAlquiler(mDto.getIdAlquiler());
		c1.setPrecio(mDto.getPrecioAlquiler());
		
		return c1;
	}

}
