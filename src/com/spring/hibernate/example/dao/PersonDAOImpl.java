package com.spring.hibernate.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.spring.hibernate.example.model.Person;


public class PersonDAOImpl implements PersonDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void save(Person p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		//session.persist(p);
		session.save(p);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> list() {
		Session session = this.sessionFactory.openSession();
		List<Person> personList = session.createQuery("from Person").list();
		session.close();
		return personList;
	}

	@Override
	public List<Person> getPersonByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		List<Person> personList= session.createQuery("from Person where name='"+ name + "'").list();
		session.close();
		return personList;
	}
	
	

}