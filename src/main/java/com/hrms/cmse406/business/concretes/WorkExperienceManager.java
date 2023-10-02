package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.WorkExperienceService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.WorkExperienceDao;
import com.hrms.cmse406.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceManager implements WorkExperienceService {

    private WorkExperienceDao workExperienceDao;

    @Autowired
    public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
        this.workExperienceDao = workExperienceDao;
    }

    @Override
    public Result add(WorkExperience workExperience) {
        this.workExperienceDao.save(workExperience);
        return new SuccessResult("Work experience is added");
    }

    @Override
    public DataResult<List<WorkExperience>> getAll() {
        return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll(), "Data Listed");
    }

    @Override
    public DataResult<List<WorkExperience>> getByOrderByEndingYear() {
        return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.getByOrderByEndingYear(), "Data Listed");
    }

	@Override
	public DataResult<List<WorkExperience>> findAllByCvs_CvId(int candidateCvId) {
		// TODO Auto-generated method stub
        return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAllByCvs_CvId(candidateCvId), "Data Listed");
	}
}
