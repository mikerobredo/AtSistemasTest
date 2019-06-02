package com.example.demo.Repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Coche;
public interface CocheRepo extends JpaRepository<Coche,Integer>{
	
public Optional<Coche> findByCarPlate(String s);	
 	
}


