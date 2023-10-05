package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {

    public List<WorkExperience> getByOrderByEndingYear();
    
    List<WorkExperience> findAllByCvs_CvId(int candidateCvId);


}
