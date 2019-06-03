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

import com.example.demo.Repo.ClienteRepo;
import com.example.demo.Service.ClientServiceImpl;
import com.example.demo.model.Alquiler;
import com.example.demo.model.Cliente;

@RunWith(value = MockitoJUnitRunner.class)
public class ClientServiceTest {
	
	@Mock
	private ClienteRepo daoMock;
	@InjectMocks
	private ClientServiceImpl service;
	
	@Test
	public void testBusClientPorId() {
		//given
		Integer i = 1;
		String s="Juan";
		String p="2001";
		List<Alquiler> a= null;		
		
		Cliente k = new Cliente (i,s,p,a);
		
		Optional<Cliente> ret= Optional.of(k);
		
		when(daoMock.findById(i)).thenReturn(ret);
		
		final Optional<Cliente> check = service.buscaPorId(i);
		assertNotNull(check);
    	assertTrue(check.isPresent());
	}
}