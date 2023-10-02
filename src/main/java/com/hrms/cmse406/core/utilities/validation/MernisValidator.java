package com.hrms.cmse406.core.utilities.validation;

import com.hrms.cmse406.entities.concretes.JobSeeker;
import org.springframework.stereotype.Service;

@Service
public class MernisValidator implements ValidationService<JobSeeker> {

    @Override
    public void Validate(JobSeeker jobSeeker) {
        jobSeeker.setStatus(true);
    }
}