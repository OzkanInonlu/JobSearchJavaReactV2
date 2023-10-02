package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.EmployerService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.ErrorResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.EmployerDao;
import com.hrms.cmse406.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;

    @Autowired
    public EmployerManager(EmployerDao employerDao) {
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data Listed");
    }

    @Override
    public Result add(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult("Employer is added");
    }

	@Override
	public Result deleteById(int id) {
		// TODO Auto-generated method stub
		Employer employer = employerDao.findByEmployerId(id);
		if(employer != null) {
			employerDao.deleteById(id);
			return new SuccessResult("Employer is removed");
		}
		return new ErrorResult("Employer not found");
	}
}