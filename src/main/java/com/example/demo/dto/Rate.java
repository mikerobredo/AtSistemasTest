package com.example.demo.dto;

import java.util.Calendar;

import lombok.Data;

@Data
public class Rate {
	
	private Integer idTarifa;		
	private Calendar fechaInicio,fechaFin;
	private Float precio;

}
