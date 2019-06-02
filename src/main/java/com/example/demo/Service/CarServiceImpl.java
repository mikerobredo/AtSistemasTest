package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.MapperComponent;
import com.example.demo.Repo.CocheRepo;
import com.example.demo.dto.Car;
import com.example.demo.model.Coche;

@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	private CocheRepo CocheRepo;
	@Autowired
	private MapperComponent<Car, Coche> servicioCoches;

	@Override
	public Optional<Coche> buscaPorId(Integer id) {
		
		 return CocheRepo.findById(id);
	}

	@Override
	public void usaPutModifica(Coche a) {
		
		Optional<Coche> c1=CocheRepo.findById(a.getId());
		
		//si hay uno con ese id--- lo guardo creo que es redundante
		if (c1.isPresent()) {CocheRepo.save(a);}
		
		else {//error hay algun nulo
		}		
	}

	@Override
	public Optional<Coche> usaPostCrea(Coche a) {		
		return CocheRepo.findById(CocheRepo.save(a).getId());		
	}

	@Override
	public void usoDelete(Integer id) {
		Optional<Coche> c1= CocheRepo.findById(id);
		if (c1.isPresent()) CocheRepo.deleteById(id);
		else
		{}
	}
	
	@Override
	public Page<Car> buscaTodosPage(String name, Pageable p) {
		Page<Coche> lc = CocheRepo.findAll(p);		
		return lc.map(x -> servicioCoches.toDto(x));		
	}

}