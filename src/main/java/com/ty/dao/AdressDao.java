package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.AdressDto;
import com.ty.dto.BranchDto;

public class AdressDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public boolean saveAddress(int branchId, AdressDto address) {
		BranchDao branchDao = new BranchDao();
		BranchDto branchDto = branchDao.getBranchById(branchId);
		if (branchDto != null) {
			branchDto.setAdressDto(address);
			entityTransaction.begin();
			entityManager.persist(address);
			entityManager.merge(branchDto);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public List<AdressDto> getAllAddress(int branchId) {
		Query query = entityManager.createQuery("select address from AdressDto address where address.branchDto.branch_id=?1");
		query.setParameter(1, branchId);
		List list = query.getResultList();
		return list;
	}

	public AdressDto getAddressById(int id) {
		BranchDao dao=new BranchDao();
		BranchDto branchDto = dao.getBranchById(id);
		AdressDto address = entityManager.find(AdressDto.class, branchDto.getAdressDto().getAddress_id());
		return address;
	}

	public void updateAddess(AdressDto address) {
		entityTransaction.begin();
		entityManager.merge(address);
		entityTransaction.commit();
	}

	public boolean deleteAddress(int id) {
		AdressDto address = entityManager.find(AdressDto.class, id);
		if (address != null) {
			entityTransaction.begin();
			entityManager.remove(address);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}
}
