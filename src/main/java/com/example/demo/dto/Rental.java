package com.example.demo.dto;

import java.util.Calendar;

import lombok.Data;


@Data
public class Rental {
	
	 private Integer id;
	    private Car car;
	    private Client client;
	    private Double price;
	    private String startDate;
	    private String endDate;

}
