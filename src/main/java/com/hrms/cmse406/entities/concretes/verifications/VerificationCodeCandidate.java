package com.hrms.cmse406.entities.concretes.verifications;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hrms.cmse406.entities.concretes.JobSeeker;

public class VerificationCodeCandidate {
	   	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    // Relationships
	    @ManyToOne
	    @JoinColumn(name = "job_seeker_id", nullable = false)
	    private JobSeeker jobSeeker;

	    @ManyToOne
	    @JoinColumn(name = "verification_code_id", nullable = false, referencedColumnName = "id")
	    private VerificationCode verificationCode;

}
