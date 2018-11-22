package com.jpa.crudRepo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.jpa.crudRepo.beans.Beans;

public interface Dao extends CrudRepository<Beans, Long>{

	@Query("select u from Beans u where u.aadhar_card = ?1")
	Beans findByAadhar(long aadharCard);

}
