package com.hrms.cmse406.api.controllers;

import com.hrms.cmse406.business.abstracts.LanguageService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.Language;
import com.hrms.cmse406.entities.concretes.WorkExperience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("/add")
    Result add(@RequestBody Language language){
        return this.languageService.add(language);
    }

    @GetMapping("/getByOrderByLevelAsc")
    DataResult<List<Language>> getByOrderByLevelAsc(){
        return this.languageService.getByOrderByLevelAsc();
    }

    @GetMapping("/getAll")
    DataResult<List<Language>> getAll(){
        return this.languageService.getAll();
    }
    

    @GetMapping("/findAllByCvs_CvId")
    DataResult<List<Language>> findAllByCvs_CvId(@RequestParam int candidateCvId) {
        return this.languageService.findAllByCvs_CvId(candidateCvId);
    }

}
