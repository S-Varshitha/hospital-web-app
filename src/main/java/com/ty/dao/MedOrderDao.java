package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.EncounterDto;
import com.ty.dto.MedOrderDto;

public class MedOrderDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean saveOrder(int encounterId, MedOrderDto order) {
		EncounterDao encounterDao = new EncounterDao();
		EncounterDto encounterDto = encounterDao.getEncounterById(encounterId);
		if (encounterDao != null) {
			order.setEncounters(encounterDto);
			entityTransaction.begin();
			entityManager.persist(order);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}

	public List<MedOrderDto> getAllOrder() {
		Query query = entityManager.createQuery("select order from MedOrderDto order");
		List list = query.getResultList();
		return list;
	}

	public MedOrderDto getOrderById(int id) {
		MedOrderDto order = entityManager.find(MedOrderDto.class, id);
		return order;
	}

	public void updateOrder(MedOrderDto order) {
		entityTransaction.begin();
		entityManager.merge(order);
		entityTransaction.commit();
	}

	public boolean deleteOrder(int id) {
		MedOrderDto order = entityManager.find(MedOrderDto.class, id);
		if (order != null) {
			entityTransaction.begin();
			entityManager.remove(order);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}
}
