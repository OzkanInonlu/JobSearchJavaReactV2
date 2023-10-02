package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.Language;
import com.hrms.cmse406.entities.concretes.School;

import java.util.List;

public interface LanguageService {

    Result add(Language language);

    DataResult<List<Language>> getByOrderByLevelAsc();

    DataResult<List<Language>> getAll();
    
    DataResult<List<Language>> findAllByCvs_CvId(int candidateCvId);


}
