package com.example.demo.MapperService;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Car;
import com.example.demo.model.Coche;

@Service//component
public class MapperServceCocheImp implements MapperService<Car,Coche>{

	@Override
	public Car toDto(Coche model) {
		
		Car c1 = new Car();
		
		c1.setColor(model.getColor());
		c1.setMarca(model.getMarca());
		c1.setMatricula(model.getMatricula());
		c1.setModelo(model.getModelo());
		
		return c1;
		
	}

	@Override
	public Coche toModel(Car mDto) {
		
		Coche c1 = new Coche();
		
		c1.setColor(mDto.getColor());
		c1.setMarca(mDto.getMarca());
		c1.setMatricula(mDto.getMatricula());
		c1.setModelo(mDto.getModelo());
		
		return c1;
	}

}
