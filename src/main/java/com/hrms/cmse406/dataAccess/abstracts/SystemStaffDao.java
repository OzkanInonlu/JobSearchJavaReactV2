package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.SystemStaff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemStaffDao extends JpaRepository<SystemStaff, Integer> {
}
