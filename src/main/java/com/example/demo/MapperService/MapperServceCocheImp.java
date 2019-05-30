package com.example.demo.MapperService;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Car;
import com.example.demo.model.Coche;

@Service//component
public class MapperServceCocheImp implements MapperService<Car,Coche>{

	@Override
	public Car toDto(Coche model) {
		
		Car c1 = new Car();		
		c1.setId(model.getId());
		c1.setCarPlate(model.getCarPlate());
		c1.setRegistrationYear(model.getRegistrationYear());		
		return c1;
		
	}

	@Override
	public Coche toModel(Car mDto) {
		
		Coche c1 = new Coche();		
		c1.setId(mDto.getId());
		c1.setCarPlate(mDto.getCarPlate());
		c1.setRegistrationYear(mDto.getRegistrationYear());	
		
		return c1;
	}

}
