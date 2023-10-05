package com.hrms.cmse406.business.abstracts;

import java.util.List;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.verifications.VerificationCode;

public interface VerificationCodeService {
	
	Result add(VerificationCode verificationCode);
	
	DataResult<List<VerificationCode>> getAll();

}
