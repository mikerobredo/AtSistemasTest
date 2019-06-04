package com.example.demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cliente;

public interface ClienteRepo extends JpaRepository<Cliente,Integer> {
	public Optional<Cliente> findByDni(String s);
}
