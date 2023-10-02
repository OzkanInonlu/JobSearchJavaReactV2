package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.AbilityService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.ErrorResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.AbilityDao;
import com.hrms.cmse406.entities.concretes.Ability;
import com.hrms.cmse406.entities.concretes.JobPosition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbilityManager implements AbilityService {

    private AbilityDao abilityDao;

    @Autowired
    public AbilityManager(AbilityDao abilityDao){
        this.abilityDao=abilityDao;
    }

    @Override
    public Result add(Ability ability) {
        this.abilityDao.save(ability);

        return new SuccessResult("Ability is added");
    }

    @Override
    public DataResult<List<Ability>> getAll() {
        return new SuccessDataResult<List<Ability>>(this.abilityDao.findAll(), "Data Listed");
    }

    @Override
    public DataResult<List<Ability>> getAllByDescriptionContains(String descrpition) {
        return new SuccessDataResult<List<Ability>>
        (this.abilityDao.getAllByDescriptionContains(descrpition), "Data Listed");
    }

	@Override
	public DataResult<List<Ability>> findAllByCvs_CvId(int candidateCvId) {
        return new SuccessDataResult<List<Ability>>
        (this.abilityDao.findAllByCvs_CvId(candidateCvId), "Data Listed");
	}

	@Override
	public Result deleteByAbilityId(int id) {
		// TODO Auto-generated method stub
		
		Ability ability = abilityDao.findByAbilityId(id);
		if(ability != null) {
			this.abilityDao.deleteById(id);
			return new SuccessResult("Ability is removed");
		}
		return new ErrorResult("Ability not found");

	}
}










