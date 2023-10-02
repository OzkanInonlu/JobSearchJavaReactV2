package com.hrms.cmse406.api.controllers;

import com.hrms.cmse406.business.abstracts.JobSeekerService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobSeekers")
public class JobSeekersController {
    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobSeeker>> getAll() {
        return this.jobSeekerService.getAll();
    }

    @GetMapping("/getByIdentityNumber")
    public DataResult<JobSeeker> getByIdentityNumber(@RequestParam String identityNumber) {
        return this.jobSeekerService.getByIdentityNumber(identityNumber);
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.add(jobSeeker);
    }

    @GetMapping("/getById")
    public DataResult<JobSeeker> getByJobSeekerId(@RequestParam int jobSeekerId) {
        return this.jobSeekerService.getByJobSeekerId(jobSeekerId);
    }

}