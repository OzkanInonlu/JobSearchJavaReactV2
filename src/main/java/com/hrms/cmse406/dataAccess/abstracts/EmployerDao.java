package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
	
	Employer findByEmployerId(int id);
}