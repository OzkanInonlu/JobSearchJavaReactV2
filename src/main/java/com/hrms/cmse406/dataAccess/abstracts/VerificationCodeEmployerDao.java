package com.hrms.cmse406.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.cmse406.entities.concretes.verifications.VerificationCodeEmployer;

public interface VerificationCodeEmployerDao extends JpaRepository<VerificationCodeEmployer, Integer>{
	
	VerificationCodeEmployer findByEmployer_Id(int id);

}
