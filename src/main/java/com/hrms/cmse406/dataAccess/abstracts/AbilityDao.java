package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.Ability;
import com.hrms.cmse406.entities.concretes.Language;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbilityDao extends JpaRepository<Ability, Integer> {

    List<Ability> getAllByDescriptionContains(String descrpition);
    
    List<Ability> findAllByCvs_CvId(int candidateCvId);
    
    //void deleteByAbilityId(int id);
    
    Ability findByAbilityId(int id);

    
    
}
