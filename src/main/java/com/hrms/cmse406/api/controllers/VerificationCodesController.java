package com.hrms.cmse406.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.cmse406.business.abstracts.VerificationCodeService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.verifications.VerificationCode;

@RestController
@RequestMapping("/api/verificationCodes")
public class VerificationCodesController {
	
	@Autowired
	private VerificationCodeService verificationCodeService;
	
	@PostMapping("/add")
	public Result add(@RequestBody VerificationCode verificationCode) {
		return this.verificationCodeService.add(verificationCode);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<VerificationCode>> getAll() {
		return this.verificationCodeService.getAll();
	}


}
