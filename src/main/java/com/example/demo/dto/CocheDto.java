package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CocheDto {
	
	public CocheDto() {
		// TODO Auto-generated constructor stub
	}
	private String matricula;
	private String color;
	private String marca;
	private String modelo;

}
