package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Cat;

public interface CatRepo extends JpaRepository<Cat, Long>{
	
	List <Cat> findByName(String name);
	
}
