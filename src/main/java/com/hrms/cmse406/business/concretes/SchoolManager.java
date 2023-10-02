package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.SchoolService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.SchoolDao;
import com.hrms.cmse406.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public Result add(School school) {
        this.schoolDao.save(school);
        return new SuccessResult("School is added");
    }

    @Override
    public DataResult<List<School>> getAll(){
    	return new SuccessDataResult<List<School>>(this.schoolDao.findAll(), "Data Listed");
    }
    
    @Override
    public DataResult<List<School>> getAllBySchoolNameContainsAndDepartmentContains(String schoolName,
            String department) {
        return new SuccessDataResult<List<School>>(
                this.schoolDao.getAllBySchoolNameContainsAndDepartmentContains(schoolName, department), "Data Listed");
    }

    @Override
    public DataResult<List<School>> getAllBySchoolNameContainsOrDepartmentContains(String schoolName,
            String department) {
        return new SuccessDataResult<List<School>>(
                this.schoolDao.getAllBySchoolNameContainsOrDepartmentContains(schoolName, department), "Data Listed");
    }

    @Override
    public DataResult<List<School>> getAllBySchoolNameContains(String schoolName) {
        return new SuccessDataResult<List<School>>(this.schoolDao.getAllBySchoolNameContains(schoolName), "Data Listed");
    }

    @Override
    public DataResult<List<School>> getAllByDepartmentContains(String department) {
        return new SuccessDataResult<List<School>>(this.schoolDao.getAllByDepartmentContains(department), "Data Listed");
    }

    public DataResult<List<School>> findAllByCvs_CvIdOrderByGraduateDateAsc(int candidateCvId) {
        return new SuccessDataResult<List<School>>(
                this.schoolDao.findAllByCvs_CvIdOrderByGraduateDateAsc(candidateCvId), "Data Listed");
    }

    public DataResult<List<School>> findAllByCvs_CvIdOrderByGraduateDateDesc(int candidateCvId) {
        return new SuccessDataResult<List<School>>(
                this.schoolDao.findAllByCvs_CvIdOrderByGraduateDateDesc(candidateCvId), "Data Listed");

    }

    public DataResult<List<School>> findAllByCvs_CvId(int candidateCvId) {
        return new SuccessDataResult<List<School>>(this.schoolDao.findAllByCvs_CvId(candidateCvId), "Data Listed");

    }

    public DataResult<School> findBySchoolId(int id) {
        return new SuccessDataResult<School>(this.schoolDao.findBySchoolId(id), "Data Listed");

    }
}
