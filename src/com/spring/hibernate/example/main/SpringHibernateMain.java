package com.spring.hibernate.example.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.spring.hibernate.example.dao.PersonDAO;
import com.spring.hibernate.example.model.Person;

public class SpringHibernateMain {

	public static void main(String[] args) {

		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("//Users/sahays/WORK/Workspaces/Eclipse_WS/Practice/HibernateExample/src/com/spring/hibernate/example/resource/spring.xml");
		
		
		PersonDAO personDAO = context.getBean(PersonDAO.class);
		/*
		Person person = new Person();
		person.setName("Vladimir"); person.setCountry("Sofia");
		
		personDAO.save(person);
		
		System.out.println("Person::"+person);
		
		List<Person> list = personDAO.list();
		
		for(Person p : list){
			System.out.println("Person List::"+p);
		}*/
		List<Person> person = personDAO.getPersonByName("Vladimir");
		for(Person p : person)
			System.out.println("Peroson country is " + p.getCountry());
		//close resources
		context.close();	
	}
}