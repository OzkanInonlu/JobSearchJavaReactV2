package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.Skill;
import com.hrms.cmse406.entities.concretes.WorkExperience;

import java.util.List;

public interface SkillService {

    Result add(Skill ability);

    DataResult<List<Skill>> getAll();

    DataResult<List<Skill>> getAllByDescriptionContains(String descrpition);
    
    DataResult<List<Skill>> findAllByCvs_CvId(int candidateCvId);
    
    Result deleteBySkillId(int id);


}
