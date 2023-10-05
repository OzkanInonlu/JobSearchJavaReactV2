package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.JobPosition;
import com.hrms.cmse406.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

    JobSeeker getByIdentityNumber(String identityNumber);

    List<JobSeeker> getAllByJobPosition_Title(String jobPositionName);

    JobSeeker getById(int jobSeekerId);

    JobSeeker findByIdentityNumber(String identityNumber);
    
    JobSeeker findByEmail(String email);
}