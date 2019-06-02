package com.example.demo;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;


import com.example.demo.Repo.TarifaRepo;
import com.example.demo.Service.RateServiceImpl;
import com.example.demo.model.Coche;
import com.example.demo.model.Tarifa;

@RunWith(value = MockitoJUnitRunner.class)
public class RateServiceTest {
	
	@Mock
	private TarifaRepo daoMock;
	@InjectMocks
	private RateServiceImpl service;
	
	@Test
	public void testBuscarPorId() {
		//given
		Integer i = 1;
		double d=5;
		@SuppressWarnings("deprecation")
		Date d1 = new Date(1,1,1);
		@SuppressWarnings("deprecation")
		Date d2 = new Date(1,1,2);
		List<Coche>c=null;
		Tarifa a = new Tarifa (i,d,d1,d2,c);
		
		Optional<Tarifa> ret= Optional.of(a);
		
		when(daoMock.findById(i)).thenReturn(ret);
		
		final Optional<Tarifa> check = service.buscaPorId(i);
		assertNotNull(check);
    	assertTrue(check.isPresent());
	}
	

}
