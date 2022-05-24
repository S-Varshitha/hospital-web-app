package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.dto.BranchDto;
import com.ty.dto.HospitalDto;

public class BranchDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	HospitalDao hospitalDao = new HospitalDao();

	public boolean saveBranch(int hospital_id, BranchDto branch) {
		HospitalDto hospital = hospitalDao.getHospitalById(hospital_id);
		if (hospital != null) {
			entityTransaction.begin();
			branch.setHospitalDto(hospital);
			entityManager.persist(branch);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}

	public List<BranchDto> getAllBranch(int hospitalId) {
		Query query = entityManager.createQuery("select branch from BranchDto branch where branch.hospitalDto.hospital_id=?1");
		query.setParameter(1,hospitalId);
		List list = query.getResultList();
		return list;
	}

	public BranchDto getBranchById(int id) {
		BranchDto branch = entityManager.find(BranchDto.class, id);
		return branch;
	}

	public void updateBranch(BranchDto branch) {
		entityTransaction.begin();
		entityManager.merge(branch);
		entityTransaction.commit();
	}
	
	

	public boolean deleteBranch(int id) {
		BranchDto branch = entityManager.find(BranchDto.class, id);
		if (branch != null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			return true;
		} else
			return false;
	}
}
