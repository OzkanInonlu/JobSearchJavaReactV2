package com.hrms.cmse406.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.cmse406.entities.concretes.verifications.VerificationCodeJobSeeker;

public interface VerificationCodeJobSeekerDao extends JpaRepository<VerificationCodeJobSeeker, Integer>{
	
	VerificationCodeJobSeeker findByJobSeeker_Id(int id);

}
