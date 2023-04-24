package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Cat;

@Service
public class CatServiceList implements CatService {
	
	
	List<Cat> cats = new ArrayList<>();

	@Override
	public Cat createCat(Cat c) {
		cats.add(c);
		return cats.get(cats.size() - 1);
	}

	@Override
	public Cat getCat(int id) {
		return this.cats.get(id);
	}

	@Override
	public List<Cat> getAll() {
		return this.cats;
	}

	@Override
	public Cat remove(int id) {
		return this.cats.remove(id);
	}

	@Override
	public Cat update(int id, String name, Boolean hasWhiskers, Boolean evil, Long length) {
		Cat c =  cats.get(id);
		if (name != null) c.setName(name);
		if (hasWhiskers != null) c.setHasWhiskers(hasWhiskers);
		if (evil != null) c.setEvil(evil);
		if (length != null) c.setLength(length);
		return c;
}
}