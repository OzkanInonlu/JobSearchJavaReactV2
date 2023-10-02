package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.JobAdvertisement;
import com.hrms.cmse406.entities.concretes.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	JobAdvertisement findByJobAdvertisementId(int id);

    List<JobAdvertisement> getAllByCity_NameContains(String name);

    List<JobAdvertisement> getAllByStatus(boolean status);

    List<JobAdvertisement> getAllByEmployer_CompanyNameAndStatus(String companyName, boolean status);

    List<JobAdvertisement> getByStatusTrue();// only get the active ones

    List<JobAdvertisement> getByStatusTrueOrderByStartDateDesc(); // aktif iş ilanları tarihe göre listelenebilmelidir

    List<JobAdvertisement> getByStatusTrueOrderByStartDateAsc(); // aktif iş ilanları tarihe göre listelenebilmelidir

    List<JobAdvertisement> getByOrderByStartDate();

    List<JobAdvertisement> getByOrderByStartDateAsc();

    List<JobAdvertisement> getByOrderByStartDateDesc();

    List<JobAdvertisement> getByOrderByEndDate();

    List<JobAdvertisement> getByOrderByEndDateAsc();

    List<JobAdvertisement> getByOrderByEndDateDesc();

    @Query("from JobAdvertisement where salary<:max and salary>:min")
    List<JobAdvertisement> getAllBySalaryBetween(int min, int max);

    List<JobAdvertisement> getByJobPosition_TitleContains(String jobName);

    @Transactional
    @Modifying
    @Query("UPDATE JobAdvertisement j SET j.status = :selectedStatus WHERE j.id = :id")
    void updateJobAdvertisementStatus(int id, boolean selectedStatus);
}
