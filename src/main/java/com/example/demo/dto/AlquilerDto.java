package com.example.demo.dto;

import java.util.Calendar;

import lombok.Data;


@Data
public class AlquilerDto {
	
	private Integer idAlquiler;
	private Calendar fechaInicioAlquiler, fechaFinAlquiler;
	private Float precioAlquiler;

}
