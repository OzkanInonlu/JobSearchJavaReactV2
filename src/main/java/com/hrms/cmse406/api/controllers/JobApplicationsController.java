package com.hrms.cmse406.api.controllers;

import com.hrms.cmse406.business.abstracts.JobApplicationService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobApplications")
public class JobApplicationsController {

    private JobApplicationService jobApplicationService;

    @Autowired
    public JobApplicationsController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }

    @PostMapping("/add")
    Result add(@RequestBody JobApplication jobApplication){
        return this.jobApplicationService.add(jobApplication);
    }

    @GetMapping("/getAllByJobSeeker_JobSeekerId")
    DataResult<List<JobApplication>> getAllByJobSeeker_JobSeekerId(int jobSeekerId){
        return this.jobApplicationService.getAllByJobSeeker_JobSeekerId(jobSeekerId);
    }

    @GetMapping("/getAll")
    DataResult<List<JobApplication>> getAll(){
        return this.jobApplicationService.getAll();
    }
}
