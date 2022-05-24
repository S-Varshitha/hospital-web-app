package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.HospitalDto;

public class HospitalDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void saveHospital(HospitalDto hospital) {
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
	}

	public List<HospitalDto> getAllHospital() {
		Query query = entityManager.createQuery("select hospital from HospitalDto hospital");
		List list = query.getResultList();
		return list;
	}

	public HospitalDto getHospitalById(int id) {
		HospitalDto hospital = entityManager.find(HospitalDto.class, id);
		return hospital;
	}

	public void updateHospital(HospitalDto hospital) {
		entityTransaction.begin();
		entityManager.merge(hospital);
		entityTransaction.commit();
	}

	public boolean deleteHospital(int id) {
		HospitalDto hospital = entityManager.find(HospitalDto.class, id);
		if (hospital != null) {
			entityTransaction.begin();
			entityManager.remove(hospital);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}
}
