package com.example.demo.Mapper;

import java.text.ParseException;

public interface MapperComponent<T,S> {
	T toDto(S model);
	S toModel(T mDto) throws ParseException;
}