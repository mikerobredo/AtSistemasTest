package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.MapperComponent;
import com.example.demo.Repo.TarifaRepo;
import com.example.demo.dto.Rate;
import com.example.demo.model.Tarifa;

	@Service
	public class RateServiceImpl implements RateService {
		
		@Autowired
		private TarifaRepo TarifaRepo;
		@Autowired
		private MapperComponent<Rate, Tarifa> servicioTarifas;

		@Override
		public Optional<Tarifa> buscaPorId(Integer id) {
			
			 return TarifaRepo.findById(id);
		}

		@Override
		public void usaPutModifica(Tarifa a) {
			
			Optional<Tarifa> c1=TarifaRepo.findById(a.getIdTarifa());
			
			//si hay uno con ese id--- lo guardo creo que es redundante
			if (c1.isPresent()) {TarifaRepo.save(a);}
			
			else {//error hay algun nulo
			}		
		}

		@Override
		public Optional<Tarifa> usaPostCrea(Tarifa a) {		
			return TarifaRepo.findById(TarifaRepo.save(a).getIdTarifa());		
		}

		@Override
		public void usoDelete(Integer id) {
			Optional<Tarifa> c1= TarifaRepo.findById(id);
			if (c1.isPresent()) TarifaRepo.deleteById(id);
			else
			{}
		}
		
		@Override
		public Page<Rate> buscaTodosPage(String name, Pageable p) {
			Page<Tarifa> lc = TarifaRepo.findAll(p);		
			return lc.map(x -> servicioTarifas.toDto(x));		
		}

}
