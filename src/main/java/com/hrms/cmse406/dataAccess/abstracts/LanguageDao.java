package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.Language;
import com.hrms.cmse406.entities.concretes.School;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LanguageDao extends JpaRepository<Language, Integer> {

    public List<Language> getByOrderByLevelAsc();
    

    List<Language> findAllByCvs_CvId(int candidateCvId);

}
