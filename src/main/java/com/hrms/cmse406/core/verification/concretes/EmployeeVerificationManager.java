package com.hrms.cmse406.core.verification.concretes;

import org.springframework.stereotype.Service;

import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.core.verification.abstracts.EmployeeVerificationService;

@Service
public class EmployeeVerificationManager implements EmployeeVerificationService {

	@Override
	public com.hrms.cmse406.core.utilities.results.Result verifyAccount() {
		return new SuccessResult("Account is verified by HRMS.");
	}

}
