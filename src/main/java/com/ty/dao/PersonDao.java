package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.PersonDto;

public class PersonDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void savePerson(PersonDto person) {
		entityTransaction.begin();
		System.out.println(person.getEmail());
		entityManager.persist(person);
		entityTransaction.commit();
	}

	public List<PersonDto> getAllPerson() {
		Query query = entityManager.createQuery("select person from PersonDto person");
		List list = query.getResultList();
		return list;
	}

	public PersonDto getPersonById(int id) {
		PersonDto person = entityManager.find(PersonDto.class, id);
		return person;
	}

	public void updatePerson(PersonDto person) {
		entityTransaction.begin();
		entityManager.merge(person);
		entityTransaction.commit();
	}

	public boolean deleteStudent(int id) {
		PersonDto person = entityManager.find(PersonDto.class, id);
		if (person != null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}
}
