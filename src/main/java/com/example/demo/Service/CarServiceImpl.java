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
		Optional<Coche> c2=CocheRepo.findByCarPlate(a.getCarPlate());
		
		//si hay uno con ese id y no hay otro con esa matricula--- lo guardo creo que es redundante
		
		if (c1.isPresent() && !c2.isPresent() ) {CocheRepo.save(a);}
		
		else {//error hay algun nulo
		}		
	}

	@Override
	public Optional<Coche> usaPostCrea(Coche a) {
		Optional<Coche> c= CocheRepo.findByCarPlate(a.getCarPlate());
		if(c.isPresent())
		{
			//devuelvo un vacio para que no se modifique nada , ya que existe uno
			Optional<Coche> empty = Optional.empty();
			return empty;
		}
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