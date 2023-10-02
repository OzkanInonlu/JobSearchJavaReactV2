package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.JobPosition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPositionDao extends JpaRepository<JobPosition,Integer> {

    List<JobPosition> getByTitleContains(String title);

    void delete(JobPosition jobPosition);
    
    //void deleteByJobPositionId(int id);
    
    JobPosition findByJobPositionId(int id);

}