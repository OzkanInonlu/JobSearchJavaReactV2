package com.hrms.cmse406.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.cmse406.business.abstracts.VerificationCodeJobSeekerService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.dataAccess.abstracts.VerificationCodeJobSeekerDao;
import com.hrms.cmse406.entities.concretes.verifications.VerificationCodeJobSeeker;

@Service
public class VerificationCodeJobSeekerManager implements VerificationCodeJobSeekerService{
	
	@Autowired
	private VerificationCodeJobSeekerDao verificationCodeJobSeekerDao;

	@Override
	public DataResult<VerificationCodeJobSeeker> findByJobSeeker_Id(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<VerificationCodeJobSeeker>(
				this.verificationCodeJobSeekerDao.findByJobSeeker_Id(id), "Data Listed");
	}

}
