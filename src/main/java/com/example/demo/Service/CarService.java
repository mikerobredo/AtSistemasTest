package com.example.demo.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.dto.Car;
import com.example.demo.model.Coche;

public interface CarService {
	public Optional<Coche> buscaPorId(Integer id);
	public void usaPutModifica(Coche a);
	public void usoDelete(Integer id);	
	public Page<Car> buscaTodosPage(String name,Pageable pageable);
	public Optional<Coche> usaPostCrea(Coche libro);
	

}
