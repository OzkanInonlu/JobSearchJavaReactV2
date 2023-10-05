package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.CvService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.ErrorResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.CvDao;
import com.hrms.cmse406.entities.concretes.Cv;
import com.hrms.cmse406.entities.concretes.School;
//import com.hrms.cmse406.entities.dtos.CvWithAllDetails;
import com.hrms.cmse406.entities.dtos.CvWithAllDetailsDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvManager implements CvService {

    private CvDao cvDao;

    @Autowired
    public CvManager(CvDao cvDao) {
        this.cvDao = cvDao;
    }

    @Override
    public Result add(Cv cv) {
        this.cvDao.save(cv);
        return new SuccessResult("Cv is added");
    }

    @Override
    public DataResult<List<Cv>> getAll() {
        return new SuccessDataResult<List<Cv>>(this.cvDao.findAll(), "Data Listed");
    }

    @Override
    public DataResult<List<Cv>> getAllBySkills_DescriptionContains(String description) {
        return new SuccessDataResult<List<Cv>>
        (this.cvDao.getAllBySkills_DescriptionContains(description), "Data Listed");
    }

    @Override
    public DataResult<List<Cv>> getAllBySchools_SchoolNameContains(String schoolName) {
        // TODO Auto-generated method stub
        return new SuccessDataResult<List<Cv>>(this.cvDao.getAllBySchools_SchoolNameContains(schoolName), "Data Listed");
    }

	@Override
	public Result deleteById(int id) {
		
		Cv cv = cvDao.findByCvId(id);
		if(cv != null) {
			cvDao.deleteById(id);
			return new SuccessResult("Cv is removed");
		}
		return new ErrorResult("Cv not found");
	}

	@Override
	public DataResult<Cv> findByJobSeeker_Id(int jobSeekerId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Cv>(this.cvDao.findByJobSeeker_Id(jobSeekerId), "Data Listed");
	}
	
    



}
