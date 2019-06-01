package com.example.demo.dto;

import lombok.Data;

@Data
public class Rate {
	
	private Integer id;
    private Double price;
    private String startDate;
    private String endDate;

}
