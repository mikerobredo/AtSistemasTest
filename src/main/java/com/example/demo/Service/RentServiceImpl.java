package com.example.demo.Service;

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
	private AlquilerRepo AlquilerRepo;
	@Autowired
	private MapperComponent<Rental, Alquiler> servicioAlquilers;

	@Override
	public Optional<Alquiler> buscaPorId(Integer id) {
		
		 return AlquilerRepo.findById(id);
	}

	@Override
	public void usaPutModifica(Alquiler a) {
		
		Optional<Alquiler> c1=AlquilerRepo.findById(a.getIdAlquiler());
		
		//si hay uno con ese id--- lo guardo creo que es redundante
		if (c1.isPresent()) {AlquilerRepo.save(a);}
		
		else {//error hay algun nulo
		}		
	}

	@Override
	public Optional<Alquiler> usaPostCrea(Alquiler a) {		
		return AlquilerRepo.findById(AlquilerRepo.save(a).getIdAlquiler());		
	}

	@Override
	public void usoDelete(Integer id) {
		Optional<Alquiler> c1= AlquilerRepo.findById(id);
		if (c1.isPresent()) AlquilerRepo.deleteById(id);
		else
		{}
	}
	
	@Override
	public Page<Rental> buscaTodosPage(String name, Pageable p) {
		Page<Alquiler> lc = AlquilerRepo.findAll(p);		
		return lc.map(x -> servicioAlquilers.toDto(x));		
	}
}
