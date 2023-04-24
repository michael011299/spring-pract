package com.example.demo.CatIntegrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.example.demo.domain.Cat;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:cat-schema.sql", "classpath:cat-data.sql"})
public class CatIntegrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception{
		Cat newCat = new Cat("chairman meow", true, true, (long) 30);
		String newCatAsJson = this.mapper.writeValueAsString(newCat);
		RequestBuilder req = post("/create").content(newCatAsJson).contentType(MediaType.APPLICATION_JSON);
		
		ResultMatcher checkStatus = status().isCreated();
		Cat created = new Cat(2, "chairman meow", true, true, (long) 30);
		String createdAsJson = this.mapper.writeValueAsString(created);
		ResultMatcher checkBody = content().json(createdAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testgetAll() throws Exception {
		List <Cat> cats = new ArrayList<>();
		Cat newCat = new Cat(1, "chairman meow", true, true, (long) 350);
		cats.add(newCat);
		String newCatsAsJson = this.mapper.writeValueAsString(cats);
		RequestBuilder req = get("/getAll");		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(newCatsAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testgetCat() throws Exception {
		Cat newCat = new Cat(1, "chairman meow", true, true, (long) 350);
		String newCatsAsJson = this.mapper.writeValueAsString(newCat);
		RequestBuilder req = get("/get/1");		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(newCatsAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testDelete() throws Exception {
		Cat newCat = new Cat(1, "chairman meow", true, true, (long) 350);
		String newCatsAsJson = this.mapper.writeValueAsString(newCat);
		RequestBuilder req = delete("/remove/1");		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(newCatsAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testPatch() throws Exception {
		Cat newCat = new Cat(1, "tony", true, true, (long) 350);
		String newCatsAsJson = this.mapper.writeValueAsString(newCat);
		RequestBuilder req = patch("/update/1").queryParam("name", "tony");		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(newCatsAsJson);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
}
