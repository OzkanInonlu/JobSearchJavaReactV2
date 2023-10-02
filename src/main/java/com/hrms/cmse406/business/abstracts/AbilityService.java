package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.Ability;
import com.hrms.cmse406.entities.concretes.WorkExperience;

import java.util.List;

public interface AbilityService {

    Result add(Ability ability);

    DataResult<List<Ability>> getAll();

    DataResult<List<Ability>> getAllByDescriptionContains(String descrpition);
    
    DataResult<List<Ability>> findAllByCvs_CvId(int candidateCvId);
    
    Result deleteByAbilityId(int id);


}
