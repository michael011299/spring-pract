package com.example.demo.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cat;
import com.example.demo.exception.CatNotFoundException;
import com.example.demo.repo.CatRepo;

@Primary
@Service
public class CatServiceDB implements CatService {

	private CatRepo repo;
	
	public CatServiceDB(CatRepo repo) {
		this.repo = repo;
	}
	
	@Override
	public Cat createCat(Cat c) {
		return this.repo.save(c);
	}

	@Override
	public Cat getCat(int id) {
		return this.repo.findById((long) id).orElseThrow(CatNotFoundException::new);
		}

	@Override
	public List<Cat> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Cat remove(int id) {
		Cat removed = this.getCat(id);
		this.repo.deleteById((long) id);
		return removed;
	}

	@Override
	public Cat update(int id, String name, Boolean hasWhiskers, Boolean evil, Long length) {
		Cat c = this.getCat(id);
		if (name != null) c.setName(name);
		if (hasWhiskers != null) c.setHasWhiskers(hasWhiskers);
		if (evil != null) c.setEvil(evil);
		if (length != null) c.setLength(length);
		return this.repo.save(c);
	}

}
