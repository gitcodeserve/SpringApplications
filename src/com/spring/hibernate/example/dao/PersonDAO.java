package com.spring.hibernate.example.dao;

import java.util.List;

import com.spring.hibernate.example.model.Person;


public interface PersonDAO {

	public void save(Person p);
	
	public List<Person> list();
	
	public List<Person> getPersonByName(String name);
	
}
