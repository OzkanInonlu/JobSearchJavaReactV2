package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.Language;
import com.hrms.cmse406.entities.concretes.Skill;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillDao extends JpaRepository<Skill, Integer> {

    List<Skill> getAllByDescriptionContains(String descrpition);
    
    List<Skill> findAllByCvs_CvId(int candidateCvId);
    
    //void deleteByAbilityId(int id);
    
    Skill findBySkillId(int id);

    
    
}
