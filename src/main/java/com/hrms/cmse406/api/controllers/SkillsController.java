package com.hrms.cmse406.api.controllers;

import com.hrms.cmse406.business.abstracts.SkillService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.Skill;
import com.hrms.cmse406.entities.concretes.WorkExperience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abilities")
public class SkillsController {

    private SkillService skillService;

    @Autowired
    public SkillsController(@RequestParam SkillService skillService){
        this.skillService=skillService;
    }

    @GetMapping("/getAll")
    DataResult<List<Skill>> getAll(){
        return this.skillService.getAll();
    }

    @GetMapping("/getAllByDescriptionContains")
    DataResult<List<Skill>> getAllByDescriptionContains(@RequestParam String descrpition){
        return this.skillService.getAllByDescriptionContains(descrpition);
    }


    @PostMapping("/add")
    Result add(@RequestBody Skill skill){
       return this.skillService.add(skill);
    }
    
    
    @DeleteMapping(value="/deleteById")
    public Result deleteById(@RequestParam int id){
        return this.skillService.deleteBySkillId(id);
    }
    
    @GetMapping("/findAllByCvs_CvId")
    DataResult<List<Skill>> findAllByCvs_CvId(@RequestParam int candidateCvId) {
        return this.skillService.findAllByCvs_CvId(candidateCvId);
    }

}
