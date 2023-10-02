package com.hrms.cmse406.api.controllers;

import com.hrms.cmse406.business.abstracts.AbilityService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.Ability;
import com.hrms.cmse406.entities.concretes.WorkExperience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/abilities")
public class AbilitiesController {

    private AbilityService abilityService;

    @Autowired
    public AbilitiesController(@RequestParam AbilityService abilityService){
        this.abilityService=abilityService;
    }

    @GetMapping("/getAll")
    DataResult<List<Ability>> getAll(){
        return this.abilityService.getAll();
    }

    @GetMapping("/getAllByDescriptionContains")
    DataResult<List<Ability>> getAllByDescriptionContains(@RequestParam String descrpition){
        return this.abilityService.getAllByDescriptionContains(descrpition);
    }


    @PostMapping("/add")
    Result add(@RequestBody Ability ability){
       return this.abilityService.add(ability);
    }
    
    
    @DeleteMapping(value="/deleteById")
    public Result deleteById(@RequestParam int id){
        return this.abilityService.deleteByAbilityId(id);
    }
    
    @GetMapping("/findAllByCvs_CvId")
    DataResult<List<Ability>> findAllByCvs_CvId(@RequestParam int candidateCvId) {
        return this.abilityService.findAllByCvs_CvId(candidateCvId);
    }

}
