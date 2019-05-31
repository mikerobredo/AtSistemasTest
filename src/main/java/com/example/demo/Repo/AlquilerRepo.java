package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.Integer;
import com.example.demo.model.Alquiler;

public interface AlquilerRepo extends JpaRepository<Alquiler,Integer>{

}
