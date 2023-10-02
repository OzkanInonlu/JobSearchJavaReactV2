package com.hrms.cmse406.core.verification.abstracts;

import com.hrms.cmse406.core.utilities.results.Result;

public interface EmailVerificationService {
	Result verifyEmail(String email);

}
