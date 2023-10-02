package com.hrms.cmse406.business.validation.abstracts;

import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.City;
import com.hrms.cmse406.entities.concretes.Employer;
import com.hrms.cmse406.entities.concretes.JobAdvertisement;
import com.hrms.cmse406.entities.concretes.JobSeeker;

public interface ValidationRuleService {
	
	Result checkCandidate(JobSeeker jobSeeker);

	Result checkEmployer(Employer employer);

	Result checkCity(City city);

	Result checkJobAdvertisement(JobAdvertisement jobAdvertisement);

}
