package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.SkillService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.ErrorResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.SkillDao;
import com.hrms.cmse406.entities.concretes.JobPosition;
import com.hrms.cmse406.entities.concretes.Skill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillManager implements SkillService {

    private SkillDao skillDao;

    @Autowired
    public SkillManager(SkillDao abilityDao){
        this.skillDao=abilityDao;
    }

    @Override
    public Result add(Skill skill) {
        this.skillDao.save(skill);

        return new SuccessResult("Skill is added");
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>(this.skillDao.findAll(), "Data Listed");
    }

    @Override
    public DataResult<List<Skill>> getAllByDescriptionContains(String descrpition) {
        return new SuccessDataResult<List<Skill>>
        (this.skillDao.getAllByDescriptionContains(descrpition), "Data Listed");
    }

	@Override
	public DataResult<List<Skill>> findAllByCvs_CvId(int candidateCvId) {
        return new SuccessDataResult<List<Skill>>
        (this.skillDao.findAllByCvs_CvId(candidateCvId), "Data Listed");
	}

	@Override
	public Result deleteBySkillId(int id) {
		// TODO Auto-generated method stub
		
		Skill skill = skillDao.findBySkillId(id);
		if(skill != null) {
			this.skillDao.deleteById(id);
			return new SuccessResult("Ability is removed");
		}
		return new ErrorResult("Ability not found");

	}
}










