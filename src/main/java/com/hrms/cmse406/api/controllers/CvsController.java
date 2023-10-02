package com.hrms.cmse406.api.controllers;

import com.hrms.cmse406.business.abstracts.CvService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.Cv;
import com.hrms.cmse406.entities.concretes.School;
import com.hrms.cmse406.entities.dtos.CvWithSchoolDetails;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {

    private CvService cvService;

    public CvsController(CvService cvService) {
        this.cvService = cvService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Cv cv) {
        return this.cvService.add(cv);
    }
    
    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam int id) {
    	return this.cvService.deleteById(id);
    }
    

    @GetMapping("/getall")
    public DataResult<List<Cv>> getAll() {
        return this.cvService.getAll();
    }

    @GetMapping("/getAllBySchool_SchoolName")
    public DataResult<List<Cv>> getAllBySchools_SchoolNameContains(@RequestParam String schoolName) {
        return this.cvService.getAllBySchools_SchoolNameContains(schoolName);
    }

    @GetMapping("/getAllByAbility_Description")
    public DataResult<List<Cv>> getAllByAbilities_DescriptionContains(@RequestParam String description) {
        return this.cvService.getAllByAbilities_DescriptionContains(description);
    }
    
   /*
    @GetMapping("/getCvWithSchoolDetails")
    public DataResult<List<CvWithSchoolDetails>> getCvWithSchoolDetails() {
        return this.cvService.getCvWithSchoolDetails();
    }
    */

}
