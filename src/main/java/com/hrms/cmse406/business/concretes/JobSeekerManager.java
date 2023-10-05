package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.JobSeekerService;
import com.hrms.cmse406.business.validation.abstracts.ValidationRuleService;
import com.hrms.cmse406.core.adapters.abstracts.MernisService;
import com.hrms.cmse406.core.utilities.results.*;
import com.hrms.cmse406.core.utilities.validation.MernisValidator;
import com.hrms.cmse406.core.utilities.validation.ValidationService;
import com.hrms.cmse406.core.verification.abstracts.EmailVerificationService;
import com.hrms.cmse406.dataAccess.abstracts.JobSeekerDao;
import com.hrms.cmse406.dataAccess.abstracts.VerificationCodeDao;
import com.hrms.cmse406.dataAccess.abstracts.VerificationCodeJobSeekerDao;
import com.hrms.cmse406.entities.concretes.JobSeeker;
import com.hrms.cmse406.entities.concretes.verifications.VerificationCode;
import com.hrms.cmse406.entities.concretes.verifications.VerificationCodeJobSeeker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private MernisService mernisService;
    private ValidationRuleService validationRuleService;
    private EmailVerificationService emailVerificationService;
    private VerificationCodeDao verificationCodeDao;
    private VerificationCodeJobSeekerDao verificationCodeJobSeekerDao;

    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisService mernisService,
            ValidationRuleService validationRuleService, EmailVerificationService emailVerificationService, 
            VerificationCodeDao verificationCodeDao, VerificationCodeJobSeekerDao verificationCodeJobSeekerDao) {
        super();
        this.jobSeekerDao = jobSeekerDao;
        this.mernisService = mernisService;
        this.validationRuleService = validationRuleService;
        this.emailVerificationService = emailVerificationService;
        this.verificationCodeDao = verificationCodeDao;
        this.verificationCodeJobSeekerDao = verificationCodeJobSeekerDao;
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Candidates listed");

    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        Result validationResult = validationRuleService.checkCandidate(jobSeeker);
        if (!validationResult.isSuccess()) {
            return new ErrorResult(validationResult.getMessage());
        }

        // use mernis
        /*
         * boolean mernisValidationResult = mernisService.checkPerson(candidate);
         * if (!mernisValidationResult) {
         * return new
         * ErrorResult("You provided an invalid identity number. Please check the given info."
         * );
         * }
         */

        // check email and id if they exist before
        boolean idValidationResult = checkId(jobSeeker);
        if (idValidationResult)
            return new ErrorResult("Identity number already exists.");

        // verify email
        
		
		VerificationCode verificationCode = new VerificationCode();
		verificationCode.setCode(emailVerificationService.generateVerificationCode());
		verificationCodeDao.save(verificationCode);
		
        
        System.out.println(this.emailVerificationService.verifyEmail(jobSeeker).getMessage());
        jobSeeker.setStatus(false);
        jobSeeker.setJobStatus(false);
        this.jobSeekerDao.save(jobSeeker);
        
		VerificationCodeJobSeeker verificationCodeJobSeeker = new VerificationCodeJobSeeker();
		verificationCodeJobSeeker.setJobSeeker(jobSeeker);
		verificationCodeJobSeeker.setVerificationCode(verificationCode);
		verificationCodeJobSeekerDao.save(verificationCodeJobSeeker);
		
		
        return new SuccessResult("The candidate is added successfully.");
    }

    public boolean checkId(JobSeeker jobSeeker) {

        JobSeeker findByIdentitynumberResult = this.jobSeekerDao.findByIdentityNumber(jobSeeker.getIdentityNumber());
        if (findByIdentitynumberResult == null)
            return false;
        return true;
    }

    @Override
    public DataResult<JobSeeker> getByIdentityNumber(String identityNumber) {
        // TODO Auto-generated method stub
        return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getByIdentityNumber(identityNumber), "Data Listed");
    }

    @Override
    public DataResult<JobSeeker> getByJobSeekerId(int jobSeekerId) {
        // TODO Auto-generated method stub
        return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(jobSeekerId), "Data Listed");
    }

}