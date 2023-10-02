package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.WorkExperience;

import java.util.List;

public interface WorkExperienceService {

    Result add(WorkExperience workExperience);

    DataResult<List<WorkExperience>> getAll();

    DataResult<List<WorkExperience>> getByOrderByEndingYear();
    
    DataResult<List<WorkExperience>> findAllByCvs_CvId(int candidateCvId);

}
