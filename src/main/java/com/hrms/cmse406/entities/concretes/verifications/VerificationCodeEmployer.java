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

import com.hrms.cmse406.entities.concretes.Employer;
import com.hrms.cmse406.entities.concretes.JobSeeker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "verification_code_employer")
public class VerificationCodeEmployer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "verification_code_id", nullable = false, referencedColumnName = "id")
    private VerificationCode verificationCode;
    

    @Column(name = "is_verified", nullable = false)
    private boolean isVerified;

    @Column(name = "verified_date")
    private LocalDateTime verifiedDate;

}
