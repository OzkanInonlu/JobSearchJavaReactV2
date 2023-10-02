package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.entities.concretes.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationDao extends JpaRepository<JobApplication, Integer> {

    List<JobApplication> getAllByJobSeeker_JobSeekerId(int jobSeekerId);

}
