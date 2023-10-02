package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.School;

import java.util.List;

public interface SchoolService {

    Result add(School school);
    
    DataResult<List<School>> getAll();

    DataResult<List<School>> getAllBySchoolNameContainsAndDepartmentContains(String schoolName, String department);

    DataResult<List<School>> getAllBySchoolNameContainsOrDepartmentContains(String schoolName, String department);

    DataResult<List<School>> getAllBySchoolNameContains(String schoolName);

    DataResult<List<School>> getAllByDepartmentContains(String department);

    DataResult<List<School>> findAllByCvs_CvIdOrderByGraduateDateAsc(int candidateCvId);

    DataResult<List<School>> findAllByCvs_CvIdOrderByGraduateDateDesc(int candidateCvId);

    DataResult<List<School>> findAllByCvs_CvId(int candidateCvId);

    DataResult<School> findBySchoolId(int id);

}
