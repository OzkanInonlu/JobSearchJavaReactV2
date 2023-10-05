package com.hrms.cmse406.entities.concretes.verifications;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

import com.hrms.cmse406.entities.concretes.JobSeeker;

import lombok.AllArgsConstructor;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "verification_code_job_seeker")
public class VerificationCodeJobSeeker {
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
	    
	    @Value("${isVerified:false}")
	    @Column(name = "is_verified", nullable = false)
	    private boolean isVerified;

	    @Column(name = "verified_date")
	    private LocalDateTime verifiedDate;

}
