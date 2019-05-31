package com.example.demo.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.dto.Rental;
import com.example.demo.model.Alquiler;


public interface RentalService {
	
	public Optional<Alquiler> buscaPorId(Integer id);
	public Rental usaPutModifica(Rental libro);
	public Rental usaPostCrea(Rental libro);
	public void usoDelete(Integer id);
	public List<Rental> buscaPorNombre(String name);
	public Page<Rental> buscaTodosPage(String name,Pageable pageable);
}
