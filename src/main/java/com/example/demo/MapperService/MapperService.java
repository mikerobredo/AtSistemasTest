package com.example.demo.MapperService;

import java.text.ParseException;

public interface MapperService<T,S> {
	T toDto(S model);
	S toModel(T mDto) throws ParseException;
}