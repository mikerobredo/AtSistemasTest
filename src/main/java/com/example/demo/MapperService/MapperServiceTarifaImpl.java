package com.example.demo.MapperService;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TarifaDto;
import com.example.demo.model.Tarifa;

@Service
public class MapperServiceTarifaImpl implements MapperService<TarifaDto,Tarifa>{

	@Override
	public TarifaDto toDto(Tarifa model) {
		
		TarifaDto c1 = new TarifaDto();
		
		c1.setFechaInicio(model.getFechaInicio());
		c1.setFechaFin(model.getFechaFin());
		c1.setIdTarifa(model.getIdTarifa());
		c1.setPrecio(model.getPrecio());
		
		return c1;
		
	}

	@Override
	public Tarifa toModel(TarifaDto mDto) {
		
		Tarifa c1 = new Tarifa();
		
		c1.setFechaInicio(mDto.getFechaInicio());
		c1.setFechaFin(mDto.getFechaFin());
		c1.setIdTarifa(mDto.getIdTarifa());
		c1.setPrecio(mDto.getPrecio());
		
		return c1;
	}

}
