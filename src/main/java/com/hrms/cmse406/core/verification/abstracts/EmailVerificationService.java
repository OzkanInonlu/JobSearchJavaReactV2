package com.hrms.cmse406.core.verification.abstracts;

import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.JobSeeker;

public interface EmailVerificationService {
	Result verifyEmail(JobSeeker jobSeeker);
	
	String generateVerificationCode();

}
