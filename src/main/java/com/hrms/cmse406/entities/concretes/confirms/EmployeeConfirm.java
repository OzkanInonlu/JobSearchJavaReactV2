package com.hrms.cmse406.entities.concretes.confirms;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.hrms.cmse406.entities.concretes.SystemStaff;

public class EmployeeConfirm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private SystemStaff employee;

    @Column(name = "is_confirmed", nullable = false)
    private boolean isConfirmed;

    @Column(name = "confirm_date")
    private LocalDate confirmDate;
}
