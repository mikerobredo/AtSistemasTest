package com.example.demo.MapperService;

public interface MapperService<T,S> {
	T toDto(S model);
	S toModel(T mDto);
}