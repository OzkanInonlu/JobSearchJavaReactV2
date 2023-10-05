package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.entities.concretes.verifications.VerificationCodeJobSeeker;

public interface VerificationCodeJobSeekerService {
	
	DataResult<VerificationCodeJobSeeker> findByJobSeeker_Id(int id);

}
