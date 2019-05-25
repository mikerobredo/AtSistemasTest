package com.example.demo.dto;

import java.util.Calendar;

import lombok.Data;

@Data
public class TarifaDto {
	
	private Integer idTarifa;		
	private Calendar fechaInicio,fechaFin;
	private Float precio;

}
