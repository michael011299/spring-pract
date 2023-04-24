package com.example.demo.unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.domain.Cat;
import com.example.demo.repo.CatRepo;
import com.example.demo.service.CatService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CatServiceDBTest {
	
	@Autowired
	private CatService service;
	
	@MockBean
	private CatRepo repo;
	
	@Test
	void testUpdate() {
		int id = 1;
		Cat existing = new Cat(1, "chairman meow", true, true, (long) 350);
		Mockito.when(this.repo.findById((long) id)).thenReturn(Optional.of(existing));
		
		Cat updated = new Cat(1, "tony", false, true, (long) 220);
		Mockito.when(this.repo.save(updated)).thenReturn(updated);
		
		Assertions.assertEquals(updated, 
				this.service.update(id, updated.getName(), updated.getHasWhiskers(), 
						updated.getEvil(), updated.getLength()));
	}
	
	@Test
	void testGetById() {
		int id = 1;
		Cat existing = new Cat(1, "chairman meow", true, true, (long) 350);
		Mockito.when(this.repo.findById((long) id)).thenReturn(Optional.of(existing));
		
		Assertions.assertEquals(existing, this.service.getCat((int) id));
	}
	
	@Test
	void testGetAll() {
		List<Cat> cats = new ArrayList<>();
		Cat existing = new Cat(1, "chairman meow", true, true, (long) 350);
		cats.add(existing);
		Mockito.when(this.repo.findAll()).thenReturn(cats);
		
		Assertions.assertEquals(cats, this.service.getAll());
	}
	
	@Test
	void testCreate() {
		Cat newCat = new Cat(1, "chairman meow", true, true, (long) 350);
		Mockito.when(this.repo.save(newCat)).thenReturn(newCat);
		
		Assertions.assertEquals(newCat, this.service.createCat(newCat));
	}
	
	@Test
	void testDelete() {
		int id = 1;
		Cat deleteCat = new Cat(1, "chairman meow", true, true, (long) 350);
		Mockito.when(this.repo.findById((long) id)).thenReturn(Optional.of(deleteCat));
		
		Assertions.assertEquals(deleteCat, this.service.remove((int) id));
	}
	
	

}
