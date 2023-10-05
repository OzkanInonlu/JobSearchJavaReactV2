package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.Employer;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface EmployerDao extends JpaRepository<Employer,Integer> {
	
	Employer findById(int id);
	
	//void deleteByEmployerId(int id);
}