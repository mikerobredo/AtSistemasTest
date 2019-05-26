package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CocheDto;

@RestController
@RequestMapping("/coche")
public class CocheController {
	//private List<CocheDto> books = new ArrayList<>();
	
	@GetMapping("/{id}")
	public CocheDto findOne(@PathVariable("id")Integer id)
	{
		CocheDto c1= new  CocheDto("2232","verde","nissa","kadet");
		return c1;

	}
	
	

}

