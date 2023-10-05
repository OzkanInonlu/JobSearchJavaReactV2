package com.hrms.cmse406.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.cmse406.business.abstracts.VerificationCodeService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.VerificationCodeDao;
import com.hrms.cmse406.entities.concretes.verifications.VerificationCode;


@Service
public class VerificationCodeManager implements VerificationCodeService{
	
	@Autowired
	private VerificationCodeDao verificationCodeDao;

	@Override
	public Result add(VerificationCode verificationCode) {
		// TODO Auto-generated method stub
		
		verificationCode.setCode(generateCode());
		this.verificationCodeDao.save(verificationCode);
		return new SuccessResult("Verification code added");
	}
	
    
	public String generateCode() {

		UUID code = UUID.randomUUID();

		return code.toString();
    }

	@Override
	public DataResult<List<VerificationCode>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<VerificationCode>>(this.verificationCodeDao.findAll(), "Data Listed");
	}

}
