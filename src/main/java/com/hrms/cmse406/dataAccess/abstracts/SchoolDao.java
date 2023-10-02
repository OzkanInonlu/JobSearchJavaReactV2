package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolDao extends JpaRepository<School, Integer> {

    List<School> getAllBySchoolNameContainsAndDepartmentContains(String schoolName, String department);

    List<School> getAllBySchoolNameContainsOrDepartmentContains(String schoolName, String department);

    List<School> getAllBySchoolNameContains(String schoolName);

    List<School> getAllByDepartmentContains(String department);

    List<School> findAllByCvs_CvIdOrderByGraduateDateAsc(int candidateCvId);

    List<School> findAllByCvs_CvIdOrderByGraduateDateDesc(int candidateCvId);

    List<School> findAllByCvs_CvId(int candidateCvId);

    School findBySchoolId(int id);

}
