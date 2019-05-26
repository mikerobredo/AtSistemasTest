package com.example.demo.MapperService;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AlquilerDto;
import com.example.demo.model.Alquiler;

@Service
public class MapperServiceAlquilerImp implements MapperService<AlquilerDto,Alquiler>{

	@Override
	public AlquilerDto toDto(Alquiler model) {
		
		AlquilerDto c1 = new AlquilerDto();
		
		c1.setFechaInicioAlquiler(model.getFechaInicioAlquiler());
		c1.setFechaFinAlquiler(model.getFechaFinAlquiler());
		c1.setIdAlquiler(model.getIdAlquiler());
		c1.setPrecioAlquiler(model.getPrecio());
		
		return c1;
		
	}

	@Override
	public Alquiler toModel(AlquilerDto mDto) {
		
		Alquiler c1 = new Alquiler();
		
		c1.setFechaInicioAlquiler(mDto.getFechaInicioAlquiler());
		c1.setFechaFinAlquiler(mDto.getFechaFinAlquiler());
		c1.setIdAlquiler(mDto.getIdAlquiler());
		c1.setPrecio(mDto.getPrecioAlquiler());
		
		return c1;
	}

}
