package com.hrms.cmse406.core.verification.concretes;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.core.verification.abstracts.EmailVerificationService;
import com.hrms.cmse406.dataAccess.abstracts.JobSeekerDao;
import com.hrms.cmse406.dataAccess.abstracts.VerificationCodeDao;
import com.hrms.cmse406.dataAccess.abstracts.VerificationCodeJobSeekerDao;
import com.hrms.cmse406.entities.concretes.JobSeeker;
import com.hrms.cmse406.entities.concretes.verifications.VerificationCode;
import com.hrms.cmse406.entities.concretes.verifications.VerificationCodeJobSeeker;


@Service
public class EmailVerificationManager implements EmailVerificationService{
	
	@Autowired
	private JobSeekerDao jobSeekerDao;
	@Autowired
	private VerificationCodeDao verificationCodeDao;
	@Autowired
	private VerificationCodeJobSeekerDao verificationCodeJobSeekerDao;
	

	@Override
	public Result verifyEmail(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		
		//JobSeeker jobSeeker = jobSeekerDao.findByEmail(email);
		
		
		
		return new SuccessResult("Please verify your account. We sent the e-mail to your e-mail address: " + jobSeeker.getEmail());
	}

	@Override
	public String generateVerificationCode() {

		UUID code = UUID.randomUUID();

		return code.toString();
	}

}
