package com.hrms.cmse406.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.cmse406.business.abstracts.VerificationCodeJobSeekerService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.entities.concretes.verifications.VerificationCodeJobSeeker;

@RestController
@RequestMapping("/api/verificationCodeJobSeekers")
public class VerificationCodeJobSeekersController {
	
	@Autowired
	private VerificationCodeJobSeekerService verificationCodeJobSeekerService;
	
	@GetMapping("/getAll")
	public DataResult<VerificationCodeJobSeeker> findByJobSeeker_Id(int id) {
		// TODO Auto-generated method stub
		return this.verificationCodeJobSeekerService.findByJobSeeker_Id(id);
	}

}
