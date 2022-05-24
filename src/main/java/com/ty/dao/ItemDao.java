package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.ItemDto;
import com.ty.dto.MedOrderDto;

public class ItemDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean saveItem(int orderId,ItemDto item) {
		MedOrderDao dao=new MedOrderDao();
		MedOrderDto order=dao.getOrderById(orderId);
		if(order!=null) {
			item.setMedOrders(order);
			entityTransaction.begin();
			entityManager.persist(item);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}

	public List<ItemDto> getAllItem() {
		Query query = entityManager.createQuery("select item from ItemDto item");
		List list = query.getResultList();
		return list;
	}

	public ItemDto getItemById(int id) {
		ItemDto item = entityManager.find(ItemDto.class, id);
		return item;
	}

	public void updateItem(ItemDto item) {
		entityTransaction.begin();
		entityManager.merge(item);
		entityTransaction.commit();
	}

	public boolean deleteItem(int id) {
		ItemDto item = entityManager.find(ItemDto.class, id);
		if (item != null) {
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}
}
