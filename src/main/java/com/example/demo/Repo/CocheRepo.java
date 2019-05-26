package com.example.demo.Repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Coche;
public interface CocheRepo extends JpaRepository<Coche,String>{
	
	//Coche findOne(String Id);

	List<Coche> findByMarcaContaining(String modelo);
	
	List<Coche> findByModeloContaining(String modelo);

}

