package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.BranchDto;
import com.ty.dto.EncounterDto;
import com.ty.dto.PersonDto;

public class EncounterDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean saveEncounter(int personId, int branchId, EncounterDto encounter) {
		PersonDao personDao = new PersonDao();
		BranchDao branchDao = new BranchDao();
		PersonDto person = personDao.getPersonById(personId);
		BranchDto branch = branchDao.getBranchById(branchId);
		if (person != null && branch != null) {
			entityTransaction.begin();
			encounter.setPersonDto(person);
			encounter.setBranchDto(branch);
			entityManager.persist(encounter);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public List<EncounterDto> getEncounterByPersonId(int personId) {
		Query query=entityManager.createQuery("select e from EncounterDto e where e.personDto.person_id=?1");
		query.setParameter(1, personId);
		return query.getResultList();
	}

	public List<EncounterDto> getAllEncounter() {
		Query query = entityManager.createQuery("select encounter from EncounterDto encounter");
		List list = query.getResultList();
		return list;
	}

	public EncounterDto getEncounterById(int id) {
		EncounterDto encounter = entityManager.find(EncounterDto.class, id);
		return encounter;
	}

	public void updateEncounter(EncounterDto encounter) {
		entityTransaction.begin();
		entityManager.merge(encounter);
		entityTransaction.commit();
	}

	public boolean deleteEncounter(int id) {
		EncounterDto encounter = entityManager.find(EncounterDto.class, id);
		if (encounter != null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}
}
