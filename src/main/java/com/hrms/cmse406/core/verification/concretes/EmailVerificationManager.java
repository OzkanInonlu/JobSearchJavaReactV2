package com.hrms.cmse406.core.verification.concretes;

import org.springframework.stereotype.Service;

import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.core.verification.abstracts.EmailVerificationService;


@Service
public class EmailVerificationManager implements EmailVerificationService{

	@Override
	public Result verifyEmail(String email) {
		// TODO Auto-generated method stub
		return new SuccessResult("Please verify your account. We sent the e-mail to your e-mail address: " + email);
	}

}
