package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.JobSeeker;

import java.util.List;

public interface JobSeekerService {

    DataResult<List<JobSeeker>> getAll();

    DataResult<JobSeeker> getByIdentityNumber(String identityNumber);

    Result add(JobSeeker jobSeeker);
    

    //DataResult<List<JobSeeker>> getAllBySortedAsc();

    DataResult<JobSeeker> getByJobSeekerId(int jobSeekerId);
}