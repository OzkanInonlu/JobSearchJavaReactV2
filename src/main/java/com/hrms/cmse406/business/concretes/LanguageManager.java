package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.LanguageService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.LanguageDao;
import com.hrms.cmse406.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public Result add(Language language) {
        this.languageDao.save(language);
        return new SuccessResult("Language is added");
    }

    @Override
    public DataResult<List<Language>> getByOrderByLevelAsc() {
        return new SuccessDataResult<List<Language>>(this.languageDao.getByOrderByLevelAsc(), "Data Listed");
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Data Listed");
    }

	@Override
	public DataResult<List<Language>> findAllByCvs_CvId(int candidateCvId) {
		// TODO Auto-generated method stub
        return new SuccessDataResult<List<Language>>(this.languageDao.findAllByCvs_CvId(candidateCvId), "Data Listed");
	}
}
