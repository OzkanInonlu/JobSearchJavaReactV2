package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.UserService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.ErrorResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.entities.concretes.JobSeeker;
import com.hrms.cmse406.core.dataAccess.UserDao;
import com.hrms.cmse406.core.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    //private ValidationService emailValidator;
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao/*, ValidationService<User> validationService*/) {
        super();
        //this.emailValidator=validationService;
        this.userDao = userDao;
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

}