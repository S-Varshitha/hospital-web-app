package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.BranchDto;
import com.ty.dto.User;

public class UserDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	public void createUser(int branchId,User user) {
		BranchDao branchDao=new BranchDao();
		BranchDto branch=branchDao.getBranchById(branchId);
		entityTransaction.begin();
		user.setBranch(branch);
		entityManager.persist(user);
		entityTransaction.commit();
	}
	public User validateUser(String email,String password) {
		Query query=entityManager.createQuery("select u from User u where email=?1 and password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> user=query.getResultList();
		if(user!=null && user.size()>0) {
			return user.get(0);
		}else {
			return null;
		}
	}
}
