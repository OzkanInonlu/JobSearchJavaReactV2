package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.JobPosition;

import java.util.List;

public interface JobPositionService {

    Result add(JobPosition jobPosition);

    Result delete(JobPosition jobPosition);

    DataResult<List<JobPosition>> getAll();

    DataResult<List<JobPosition>> getAllSortedAsc();
    
    DataResult<List<JobPosition>> getByTitleContains(String title);
    
    
    Result deleteByJobPositionId(int id);


}