package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationService {

   Result add(JobApplication jobApplication);

   DataResult<List<JobApplication>> getAllByJobSeeker_JobSeekerId(int jobSeekerId);

   DataResult<List<JobApplication>> getAll();

}
