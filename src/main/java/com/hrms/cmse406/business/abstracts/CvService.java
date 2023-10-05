package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.Cv;
import com.hrms.cmse406.entities.concretes.School;
import com.hrms.cmse406.entities.dtos.CvWithAllDetailsDto;

import java.util.List;

public interface CvService {

    Result add(Cv cv);

    DataResult<List<Cv>> getAll();

    DataResult<List<Cv>> getAllBySchools_SchoolNameContains(String schoolName);

    DataResult<List<Cv>> getAllBySkills_DescriptionContains(String description);
        
    DataResult<Cv> findByJobSeeker_Id(int jobSeekerId);
    
    Result deleteById(int id);
    
    
    
    
    

}
