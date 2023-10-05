package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.UserService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.ErrorResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.JobSeekerDao;
import com.hrms.cmse406.dataAccess.abstracts.VerificationCodeJobSeekerDao;
import com.hrms.cmse406.entities.concretes.JobSeeker;
import com.hrms.cmse406.entities.concretes.verifications.VerificationCodeJobSeeker;
import com.hrms.cmse406.core.dataAccess.UserDao;
import com.hrms.cmse406.core.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserManager implements UserService {

    //private ValidationService emailValidator;
    private UserDao userDao;
    private VerificationCodeJobSeekerDao verificationCodeJobSeekerDao;
    private JobSeekerDao jobSeekerDao;
   

    @Autowired
    public UserManager(UserDao userDao, VerificationCodeJobSeekerDao verificationCodeJobSeekerDao, 
    		 JobSeekerDao jobSeekerDao) {
        super();
        //this.emailValidator=validationService;
        this.userDao = userDao;
        this.verificationCodeJobSeekerDao = verificationCodeJobSeekerDao;
        this.jobSeekerDao = jobSeekerDao;
    }


    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Data Listed") ;
    }

    @Override
    public Result add(User user) {
        //this.emailValidator.Validate(user);
    	
    	boolean checkEmailResult = checkEmail(user);
    	if(checkEmailResult) {
			return new ErrorResult("E-mail already exists.");
    	}
        this.userDao.save(user);
        return new SuccessResult("User added");
    }
    
	@Override
	public Result verifyJobSeeker(int userId, String code) {
		// TODO Auto-generated method stub
		
		JobSeeker user = jobSeekerDao.getById(userId);
		
		if(user != null) {
			
			VerificationCodeJobSeeker verificationCode = verificationCodeJobSeekerDao.findByJobSeeker_Id(user.getId());
			
			if(!code.equals(verificationCode.getVerificationCode().getCode())) {
				user.setStatus(false);
				jobSeekerDao.save(user);
				return new ErrorResult("Wrong code entered");
			}
			user.setStatus(true);
			verificationCode.setVerified(true);
			verificationCode.setVerifiedDate(LocalDateTime.now());
			
			jobSeekerDao.save(user);
			verificationCodeJobSeekerDao.save(verificationCode);
			return new SuccessResult("Code verified");
		}
		
		return new ErrorResult("No user found with id : " + userId);
		
	}
    
    public boolean checkEmail(User user) {

        User findByEmailResult = this.userDao.findByEmail(user.getEmail());
        if (findByEmailResult == null)
            return false;
        return true;
    }

    @Override
    public DataResult<User> getUserByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.findByEmail(email), "Data Listed");
    }

    @Override
    public Result delete(User user) {
        this.userDao.delete(user);
        return new SuccessResult("User Deleted");
    }


	@Override
	public Result deleteById(int id) {
		// TODO Auto-generated method stub
		this.userDao.deleteById(id);
		return new SuccessResult("User deleted");
	}


}