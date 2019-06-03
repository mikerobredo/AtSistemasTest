package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.Repo.AlquilerRepo;
import com.example.demo.Service.RentServiceImpl;
import com.example.demo.model.Alquiler;
import com.example.demo.model.Cliente;
import com.example.demo.model.Coche;

@RunWith(value = MockitoJUnitRunner.class)
public class RentalServiceTest {
	
	@Mock
	private AlquilerRepo daoMock;
	@InjectMocks
	private RentServiceImpl service;
	
	@Test
	public void testBusRentalPorId() {
		//given
		Integer i = 1;
		double d=5;
		@SuppressWarnings("deprecation")
		Date d1 = new Date(1,1,1);
		@SuppressWarnings("deprecation")
		Date d2 = new Date(1,1,2);
		Coche c= null;
		Cliente c2 = null;
		
		Alquiler k = new Alquiler(i,d1,d2,d,c,c2);
		
		Optional<Alquiler> ret= Optional.of(k);
		
		when(daoMock.findById(i)).thenReturn(ret);
		
		final Optional<Alquiler> check = service.buscaPorId(i);
		assertNotNull(check);
    	assertTrue(check.isPresent());
	}
}