package com.example.demo.Mapper;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Rate;
import com.example.demo.model.Tarifa;

@Component
public class MapperComponentTarifaImpl implements MapperComponent<Rate,Tarifa>{

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
	public Tarifa toModel(Rate mDto) throws ParseException {
		
		
		Tarifa c1 = new Tarifa();
		
		String s = mDto.getStartDate();
		String e = mDto.getEndDate();
		//SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date1 = formatter1.parse(s);  
		Date date2 = formatter1.parse(e);
		
		c1.setFechaInicio(date1);
		c1.setFechaFin(date2);
		c1.setIdTarifa(mDto.getId());
		c1.setPrecio(mDto.getPrice());
		
		return c1;
	}

}
