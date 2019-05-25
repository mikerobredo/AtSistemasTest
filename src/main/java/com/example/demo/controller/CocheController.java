package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CocheDto;



@RestController
@RequestMapping("/coche")
public class CocheController {
	private List<CocheDto> books = new ArrayList<>();
	

}
