package com.hrms.cmse406.entities.concretes.confirms;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hrms.cmse406.entities.concretes.Employer;

public class EmployeeConfirmEmployer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "employee_confirm_id", nullable = false)
    private EmployeeConfirm employeeConfirm;

    @ManyToOne
    @JoinColumn(name = "employer_id", nullable = false)
    private Employer employer;
}
