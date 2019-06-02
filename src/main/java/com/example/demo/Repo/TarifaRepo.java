package com.example.demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Tarifa;

public interface TarifaRepo extends JpaRepository<Tarifa,Integer>{
	
	Optional<Tarifa> findById(Integer id);

}
