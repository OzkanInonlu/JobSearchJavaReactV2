package com.hrms.cmse406.business.validation.concretes;

import java.time.Year;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.cmse406.business.validation.abstracts.ValidationRuleService;
import com.hrms.cmse406.core.dataAccess.UserDao;
import com.hrms.cmse406.core.entities.concretes.User;
import com.hrms.cmse406.core.utilities.results.ErrorResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.entities.concretes.City;
import com.hrms.cmse406.entities.concretes.Employer;
import com.hrms.cmse406.entities.concretes.JobAdvertisement;
import com.hrms.cmse406.entities.concretes.JobSeeker;


@Service
public class ValidationRuleManager implements ValidationRuleService{
	
	@Autowired
	private UserDao userDao;

    @Override
	public Result checkCandidate(JobSeeker jobSeeker) {

		Year currentYear = Year.now();
		
	
		if (jobSeeker.getFirstName().isEmpty() || jobSeeker.getLastName().isEmpty() || jobSeeker.getIdentityNumber().isEmpty() 
        || jobSeeker.getEmail().isEmpty() || jobSeeker.getPassword().isEmpty()) {
			return new ErrorResult("Please fill the blanks completely.");
		}

		if (jobSeeker.getBirthDate().getYear() <= 0 || jobSeeker.getBirthDate().getYear() > currentYear.getValue()) {
			return new ErrorResult("Wrong birth of year.");
		}
		return new SuccessResult("Validation OK.");
		
	}

	@Override
	public Result checkEmployer(Employer employer) {

		if (employer.getCompanyName().isEmpty() || employer.getWebAddress().isEmpty() || employer.getEmail().isEmpty() || employer.getPhoneNumber().isEmpty()
				|| employer.getPassword().isEmpty()) {
			return new ErrorResult("Please fill the blanks completely.");
		}
			
		
		else {
			String[] parts = employer.getEmail().split("@");
			String domain = parts[1]; 
			
			if(!domain.equals(employer.getWebAddress())) {
				return new ErrorResult("Your email must contain the domain in it.");
			}
			return new SuccessResult("Validation OK.");
		}
			
		/*	
		else if (!employer.getEmail().contains(employer.getWebAddress()))
			return new ErrorResult("Your email must contain the domain in it.");

		return new SuccessResult("Validation OK.");
		*/
	}
	
	@Override
	public Result checkCity(City city) {

		if (city.getName().isEmpty())
			return new ErrorResult("The city name can not be empty.");
		return new SuccessResult("Validation OK.");
	}

	@Override
	public Result checkJobAdvertisement(JobAdvertisement jobAdvertisement) {

		if (jobAdvertisement.getDescription().isEmpty())
			return new ErrorResult("Please fill the blanks completely.");
		if (jobAdvertisement.getFreePositionAmount() <= 0)
			return new ErrorResult("Free position amount can't be zero or less.");

		return new SuccessResult("Validation OK.");
	}
	
}
