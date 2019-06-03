package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.MapperComponent;
import com.example.demo.Repo.ClienteRepo;
import com.example.demo.dto.Client;
import com.example.demo.model.Cliente;
import com.example.demo.model.Coche;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClienteRepo ClienteRepo;
	@Autowired
	private MapperComponent<Client, Cliente> servicioClientes;

	@Override
	public Optional<Cliente> buscaPorId(Integer id) {
		
		 return ClienteRepo.findById(id);
	}

	@Override
	public void usaPutModifica(Cliente a) {
		
		Optional<Cliente> c1=ClienteRepo.findById(a.getIdPersona());
		
		//si hay uno con ese id--- lo guardo creo que es redundante
		if (c1.isPresent()) {ClienteRepo.save(a);}
		
		else {//error hay algun nulo
		}		
	}

	@Override
	public Optional<Cliente> usaPostCrea(Cliente a) {	
		
		Optional<Cliente> c= ClienteRepo.findByDni(a.getDni());
		if(c.isPresent())
		{
			//devuelvo un vacio para que no se modifique nada , ya que existe uno
			Optional<Cliente> empty = Optional.empty();
			return empty;
		}
		return ClienteRepo.findById(ClienteRepo.save(a).getIdPersona());		
	}

	@Override
	public void usoDelete(Integer id) {
		Optional<Cliente> c1= ClienteRepo.findById(id);
		if (c1.isPresent()) ClienteRepo.deleteById(id);
		else
		{}
	}
	
	@Override
	public Page<Client> buscaTodosPage(String name, Pageable p) {
		Page<Cliente> lc = ClienteRepo.findAll(p);		
		return lc.map(x -> servicioClientes.toDto(x));		
	}
}
