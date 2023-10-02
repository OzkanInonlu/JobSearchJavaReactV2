package com.hrms.cmse406.api.controllers;

import com.hrms.cmse406.business.abstracts.SchoolService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

    private SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody School school) {
        return this.schoolService.add(school);
    }

    @GetMapping("/getAll")
    public DataResult<List<School>> getAll(){
    	return this.schoolService.getAll();
    }
    
    @GetMapping("/getAllBySchoolNameContainsAndDepartmentContains")
    public DataResult<List<School>> getAllBySchoolNameContainsAndDepartmentContains(@RequestParam String schoolName, @RequestParam String department) {
        return this.schoolService.getAllBySchoolNameContainsAndDepartmentContains(schoolName, department);
    }

    @GetMapping("/getAllBySchoolNameContainsOrDepartmentContains")
    public DataResult<List<School>> getAllBySchoolNameContainsOrDepartmentContains(@RequestParam String schoolName,
    @RequestParam String department) {
        return this.schoolService.getAllBySchoolNameContainsOrDepartmentContains(schoolName, department);

    }

    @GetMapping("/getAllBySchoolNameContains")
    public DataResult<List<School>> getAllBySchoolNameContains(@RequestParam String schoolName) {
        return this.schoolService.getAllBySchoolNameContains(schoolName);

    }

    @GetMapping("/getAllByDepartmentContains")
    public DataResult<List<School>> getAllByDepartmentContains(@RequestParam String department) {
        return this.schoolService.getAllByDepartmentContains(department);

    }

    @GetMapping("/findAllByCvs_CvIdOrderByGraduateDateAsc")
    public DataResult<List<School>> findAllByCvs_CvIdOrderByGraduateDateAsc(@RequestParam int candidateCvId) {

        return this.schoolService.findAllByCvs_CvIdOrderByGraduateDateAsc(candidateCvId);

    }

    @GetMapping("/findAllByCvs_CvIdOrderByGraduateDateDesc")
    public DataResult<List<School>> findAllByCvs_CvIdOrderByGraduateDateDesc(@RequestParam int candidateCvId) {
        return this.schoolService.findAllByCvs_CvIdOrderByGraduateDateDesc(candidateCvId);

    }

    @GetMapping("/findAllByCvs_CvId")
    public DataResult<List<School>> findAllByCvs_CvId(@RequestParam int candidateCvId) {
        return this.schoolService.findAllByCvs_CvId(candidateCvId);
    }

    @GetMapping("/findBySchoolId")
    public DataResult<School> findBySchoolId(@RequestParam int id) {

        return this.schoolService.findBySchoolId(id);


    }
}