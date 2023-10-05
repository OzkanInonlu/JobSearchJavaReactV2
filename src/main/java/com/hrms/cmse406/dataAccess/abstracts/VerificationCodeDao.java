package com.hrms.cmse406.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.cmse406.entities.concretes.verifications.VerificationCode;

public interface VerificationCodeDao extends JpaRepository<VerificationCode, Integer>{

}
