package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.MapperComponent;
import com.example.demo.Repo.AlquilerRepo;
import com.example.demo.Repo.CocheRepo;
import com.example.demo.Repo.ClienteRepo;
import com.example.demo.dto.Rental;
import com.example.demo.model.Alquiler;
import com.example.demo.model.Cliente;
import com.example.demo.model.Coche;
import com.example.demo.model.Tarifa;

@Service
public class RentServiceImpl implements RentalService {
	
	@Autowired
	private AlquilerRepo AlquilerRepo;
	@Autowired
	private MapperComponent<Rental, Alquiler> servicioAlquilers;
	
	@Autowired
	private CocheRepo CocheRepo;
	@Autowired
	private ClienteRepo clienteRepo;
	

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
		Optional<Coche> c= CocheRepo.findById(a.getCocheAlquilado().getId());
		Optional<Cliente>c1 =clienteRepo.findById(a.getClienteAlquilado().getIdPersona());
		
		if(c.isPresent()&& c1.isPresent())
		{
			a.setCocheAlquilado(c.get());
			a.setClienteAlquilado(c1.get());
			List<Tarifa> t= c.get().getTarifas();
			double d=0;
			
			for (Tarifa actual : t) {
				if (actual.getFechaInicio().before(a.getFechaInicioAlquiler()) && 
						actual.getFechaFin().after(a.getFechaFinAlquiler()))
						{
							
							d=(actual.getPrecio());
							int dias=(int) ((a.getFechaFinAlquiler().getTime()-
									a.getFechaInicioAlquiler().getTime())/86400000);
							a.setPrecio(actual.getPrecio()* (dias));
						}			   
			}
			if(d>0) {	
				
				return AlquilerRepo.findById(AlquilerRepo.save(a).getIdAlquiler());			
			}
			else 		return Optional.empty();			
		}
		else	return Optional.empty();			
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
