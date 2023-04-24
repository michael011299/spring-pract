package com.example.demo.domain;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Boolean hasWhiskers;
	private String name;
	private Boolean evil;
	private Long length;
	
	public Cat(){
		
	}
	
	public Cat(String name, Boolean hasWhiskers, Boolean evil, Long length){
		super();
		this.setName(name);
		this.setHasWhiskers(hasWhiskers);
		this.setEvil(evil);
		this.setLength(length);
		
	}
	
	public Cat(int id, String name, Boolean hasWhiskers,  Boolean evil, Long length){
		super();
		this.setId(id);
		this.setName(name);
		this.setHasWhiskers(hasWhiskers);
		this.setEvil(evil);
		this.setLength(length);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Boolean getHasWhiskers() {
		return hasWhiskers;
	}
	public void setHasWhiskers(Boolean hasWhiskers) {
		this.hasWhiskers = hasWhiskers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getEvil() {
		return evil;
	}
	public void setEvil(Boolean evil) {
		this.evil = evil;
	}
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}

	@Override
	public int hashCode() {
		return Objects.hash(evil, hasWhiskers, id, length, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return Objects.equals(evil, other.evil) && Objects.equals(hasWhiskers, other.hasWhiskers) && id == other.id
				&& Objects.equals(length, other.length) && Objects.equals(name, other.name);
	}


	
	

}
