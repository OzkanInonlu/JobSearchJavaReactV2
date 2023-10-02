package com.hrms.cmse406.api.controllers;


import com.hrms.cmse406.business.abstracts.JobPositionService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {

    private JobPositionService service;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.service = jobPositionService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
        return service.getAll();
    }

    @GetMapping("/getallsortedasc")
    public DataResult<List<JobPosition>> getAllSortedAsc(){
        return service.getAllSortedAsc();
    }

    @PostMapping(value="/add")
    public Result add(@Valid @RequestBody JobPosition jobPosition){
        return this.service.add(jobPosition);
    }

    @DeleteMapping(value="/delete")
    public Result delete(@Valid @RequestBody JobPosition jobPosition){
        return this.service.delete(jobPosition);
    }
    
    
    @DeleteMapping(value="/deleteById")
    public Result deleteById(@RequestParam int id){
        return this.service.deleteByJobPositionId(id);
    }
    
    
	public DataResult<List<JobPosition>> getByTitleContains(@RequestParam String title) {
		return this.service.getByTitleContains(title);
	}

}