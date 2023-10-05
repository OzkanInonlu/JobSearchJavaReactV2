package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.Cv;
import com.hrms.cmse406.entities.dtos.CvWithAllDetailsDto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

@Transactional
public interface CvDao extends JpaRepository<Cv, Integer> {

    List<Cv> getAllBySchools_SchoolNameContains(String schoolName);

    List<Cv> getAllBySkills_DescriptionContains(String description);

    Cv findByCvId(int id);
    
    Cv findByJobSeeker_Id(int id);
    
    
    
    /*
	//inner join
    @Query("SELECT NEW com.hrms.cmse406.entities.dtos.CvWithSchoolDetails(cv.cvId, " +
    	       "(SELECT DISTINCT s FROM School s JOIN cv.schools sc WHERE s.id = sc.id)) " +
    	       "FROM Cv cv")
    List<CvWithSchoolDetails> getCvWithSchoolDetails();
    */

}
