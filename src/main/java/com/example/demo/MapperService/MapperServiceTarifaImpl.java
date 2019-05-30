package com.example.demo.MapperService;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Rate;
import com.example.demo.model.Tarifa;

@Service
public class MapperServiceTarifaImpl implements MapperService<Rate,Tarifa>{

	@Override
	public Rate toDto(Tarifa model) {
		
		Rate c1 = new Rate();
		
		c1.setStartDate(model.getFechaInicio().toString());
		c1.setEndDate(model.getFechaFin().toString());
		c1.setId(model.getIdTarifa());
		c1.setPrice(model.getPrecio());
		
		return c1;
		
	}

	@Override
	public Tarifa toModel(Rate mDto) {
		
		Tarifa c1 = new Tarifa();
		
		c1.setFechaInicio(mDto.getStartDate());
		c1.setFechaFin(mDto.getEndDate());
		c1.setIdTarifa(mDto.getId());
		c1.setPrecio(mDto.getPrice());
		
		return c1;
	}

}
