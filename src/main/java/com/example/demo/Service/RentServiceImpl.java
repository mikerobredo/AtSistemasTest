package com.example.demo.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.MapperComponent;
import com.example.demo.Repo.AlquilerRepo;
import com.example.demo.dto.Rental;
import com.example.demo.model.Alquiler;

@Service
public class RentServiceImpl implements RentalService {
	
	@Autowired
	private AlquilerRepo alquilerControlador;
	@Autowired
	private MapperComponent<Rental, Alquiler> servicioAlquilers;

	@Override
	public Optional<Alquiler> buscaPorId(Integer id) {		
		 Optional<Alquiler> c1= alquilerControlador.findById(id);
		 return c1;
	}

	@Override
	public Rental usaPutModifica(Rental libro) {
		
		return null;
	}

	@Override
	public Rental usaPostCrea(Rental libro) {
		
		return null;
	}

	@Override
	public void usoDelete(Integer id) {
		Optional<Alquiler> c1= alquilerControlador.findById(id);
		if (c1.isPresent()) alquilerControlador.deleteById(id);		
	}

	@Override
	public List<Rental> buscaPorNombre(String name) {
		
		return null;
	}

	@Override
	public Page<Rental> buscaTodosPage(String name, Pageable p) {
		Page<Alquiler> lc = alquilerControlador.findAll(p);		
		return lc.map(x -> servicioAlquilers.toDto(x));		
	}

}
