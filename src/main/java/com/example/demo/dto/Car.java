package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	private Integer id;
    private String carPlate;
    private String registrationYear;

}
