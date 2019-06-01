package com.example.demo.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.dto.Client;
import com.example.demo.model.Cliente;

public interface ClientService {
	
	public Optional<Cliente> buscaPorId(Integer id);
	public void usaPutModifica(Cliente a);
	public void usoDelete(Integer id);	
	public Page<Client> buscaTodosPage(String name,Pageable pageable);
	public Optional<Cliente> usaPostCrea(Cliente libro);
	
}