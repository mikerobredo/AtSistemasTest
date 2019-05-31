package com.example.demo.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.example.demo.dto.Car;
import com.example.demo.dto.Client;
import com.example.demo.dto.Rate;
import com.example.demo.dto.Rental;
import com.example.demo.model.Alquiler;
import com.example.demo.model.Cliente;
import com.example.demo.model.Coche;
import com.example.demo.model.Tarifa;


@Component
public class MapperComponentAlquilerImp implements MapperComponent<Rental,Alquiler>{

	
	@Autowired
	private MapperComponent<Car, Coche> MapperCar;
	@Autowired
	private MapperComponent<Client, Cliente> MapperClient;
	
	
	@Override
	public Rental toDto(Alquiler model) {
		
		Rental c1 = new Rental();
		
		c1.setStartDate(model.getFechaInicioAlquiler().toString());
		c1.setEndDate(model.getFechaFinAlquiler().toString());
		c1.setId(model.getIdAlquiler());
		c1.setPrice(model.getPrecio());
		
		
		c1.setCar(MapperCar.toDto(model.getCocheAlquilado()));
		c1.setClient(MapperClient.toDto(model.getClienteAlquilado()));
		
		return c1;
		
	}

	@Override
	public Alquiler toModel(Rental mDto) throws ParseException {
		
		Alquiler c1 = new Alquiler();
		
		String s = mDto.getStartDate();
		String e = mDto.getEndDate();
		
		SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date1 = formatter1.parse(s);  
		Date date2 = formatter1.parse(e);
		
		c1.setClienteAlquilado(MapperClient.toModel(mDto.getClient()));
		c1.setCocheAlquilado(MapperCar.toModel(mDto.getCar()));
		c1.setIdAlquiler(mDto.getId());
		c1.setPrecio(mDto.getPrice());
		c1.setFechaFinAlquiler(date2);
		c1.setFechaInicioAlquiler(date1);
		
		
		return c1;
	}

}
