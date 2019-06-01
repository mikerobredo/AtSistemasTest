package com.example.demo.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.dto.Rental;
import com.example.demo.model.Alquiler;

public interface RentalService {
	
	public Optional<Alquiler> buscaPorId(Integer id);
	public void usaPutModifica(Alquiler a);
	public void usoDelete(Integer id);	
	public Page<Rental> buscaTodosPage(String name,Pageable pageable);
	public Optional<Alquiler> usaPostCrea(Alquiler libro);
	
}