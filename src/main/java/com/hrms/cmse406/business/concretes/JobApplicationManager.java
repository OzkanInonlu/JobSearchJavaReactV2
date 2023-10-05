package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.JobApplicationService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.JobApplicationDao;
import com.hrms.cmse406.entities.concretes.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationManager implements JobApplicationService {

    private JobApplicationDao jobApplicationDao;

    @Autowired
    public JobApplicationManager(JobApplicationDao jobApplicationDao) {
        this.jobApplicationDao = jobApplicationDao;
    }

    @Override
    public Result add(JobApplication jobApplication) {
        this.jobApplicationDao.save(jobApplication);
        return new SuccessResult("Job application is added");
    }

    @Override
    public DataResult<List<JobApplication>> getAllByJobSeeker_JobSeekerId(int jobSeekerId) {
        return new SuccessDataResult<List<JobApplication>>(
                this.jobApplicationDao.getAllByJobSeeker_Id(jobSeekerId), "Data Listed");
    }

    @Override
    public DataResult<List<JobApplication>> getAll() {
        return new SuccessDataResult<List<JobApplication>>(this.jobApplicationDao.findAll(), "Data Listed");
    }
}
