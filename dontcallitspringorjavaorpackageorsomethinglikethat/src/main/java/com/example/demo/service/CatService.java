package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.Cat;

public interface CatService {
	Cat createCat(Cat c);
	Cat getCat(int id);
	List<Cat> getAll();
	Cat remove(int id);
	Cat update(int id, String name, Boolean hasWhiskers, Boolean evil, Long length);
}
