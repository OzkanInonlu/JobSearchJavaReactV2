package com.hrms.cmse406.api.controllers;

import com.hrms.cmse406.business.abstracts.WorkExperienceService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workExperiences")
public class WorkExperincesController {

    private WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperincesController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @PostMapping("/add")
    Result add(@RequestBody WorkExperience workExperience) {
        return this.workExperienceService.add(workExperience);
    }

    @GetMapping("/getall")
    DataResult<List<WorkExperience>> getAll() {
        return this.workExperienceService.getAll();
    }

    @GetMapping("/getByOrderByEndingYear")
    DataResult<List<WorkExperience>> getByOrderByEndingYear() {
        return this.workExperienceService.getByOrderByEndingYear();
    }
    

    @GetMapping("/findAllByCvs_CvId")
    DataResult<List<WorkExperience>> findAllByCvs_CvId(@RequestParam int candidateCvId) {
        return this.workExperienceService.findAllByCvs_CvId(candidateCvId);
    }
}
