package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.JobPositionService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.ErrorResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.JobPositionDao;
import com.hrms.cmse406.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionMananger implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionMananger(JobPositionDao jobPositionDao) {
        super();
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
    }

    @Override
    public Result add(JobPosition jobPosition) {
        this.jobPositionDao.save(jobPosition);
        return new SuccessResult("Job position is added");
    }

    @Override
    public Result delete(JobPosition jobPosition) {
        this.jobPositionDao.delete(jobPosition);
        return new SuccessResult("Job position is removed");
    }

    @Override
    public DataResult<List<JobPosition>> getAllSortedAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC, "title");
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(sort), "Data Listed");
    }

	@Override
	public DataResult<List<JobPosition>> getByTitleContains(String title) {
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.getByTitleContains(title), "Data Listed");
	}

	@Override
	public Result deleteByJobPositionId(int id) {
		
		JobPosition jobPosition = jobPositionDao.findByJobPositionId(id);
		if(jobPosition != null) {
			this.jobPositionDao.deleteById(id);
			return new SuccessResult("Job position is removed");
		}
		return new ErrorResult("Job position not found");
	}
}