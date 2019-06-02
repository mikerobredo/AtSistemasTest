package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.Repo.CocheRepo;
import com.example.demo.Service.CarServiceImpl;
import com.example.demo.model.Alquiler;
import com.example.demo.model.Coche;
import com.example.demo.model.Tarifa;

@RunWith(value = MockitoJUnitRunner.class)
public class CarServiceTest {
	
	@Mock
	private CocheRepo daoMock;
	@InjectMocks
	private CarServiceImpl service;
	
	@Test
	public void testBuscarPorId() {
		//given
		Integer i = 1;
		String s="Juan";
		String p="2001";
		List<Alquiler> a= null;
		List<Tarifa> b=null;		
		
		Coche k = new Coche (i,s,p,a,b);
		
		Optional<Coche> ret= Optional.of(k);
		
		when(daoMock.findById(i)).thenReturn(ret);
		
		final Optional<Coche> check = service.buscaPorId(i);
		assertNotNull(check);
    	assertTrue(check.isPresent());
	}
}