package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WellcomeController {
	
	@GetMapping
	public String hola() {
		return ("Bienvenido a la web de alquiler");
	}

}
