package com.example.demo.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.dto.Rate;
import com.example.demo.model.Tarifa;

public interface RateService {
	
	public Optional<Tarifa> buscaPorId(Integer id);
	public void usaPutModifica(Tarifa a);
	public void usoDelete(Integer id);	
	public Page<Rate> buscaTodosPage(String name,Pageable pageable);
	public Optional<Tarifa> usaPostCrea(Tarifa libro);
	
}