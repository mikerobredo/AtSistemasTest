package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Alquiler;

public interface AlquilerRepo extends JpaRepository<Alquiler,Integer>{

	/*
	@Query ("SELECT MAX(suma) from (SELECT sum(precio)AS suma,coche_alquilado_id FROM Alquiler where fecha_fin_alquiler BETWEEN '1980-03-26 00:00:01' and '2900-03-26 00:00:01'	And fecha_inicio_alquiler BETWEEN '1980-03-26 00:00:01' and '2900-03-26 00:00:01'							GROUP BY coche_alquilado_id) AS t1")
	long count();*/
}
