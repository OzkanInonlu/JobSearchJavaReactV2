package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.JobAdvertisement;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface JobAdvertisementService {

    DataResult<List<JobAdvertisement>> getAll();

    Result add(JobAdvertisement jobAdvertisement);
    
    Result deleteById(int id);

    DataResult<List<JobAdvertisement>> getAllByCity_NameContains(String name);

    DataResult<List<JobAdvertisement>> getAllByStatus(boolean status);

    DataResult<List<JobAdvertisement>> getAllByEmployer_CompanyNameAndStatus(String companyName, boolean status);

    DataResult<List<JobAdvertisement>> getByStatusTrue();// only get the active ones

    DataResult<List<JobAdvertisement>> getByStatusTrueOrderByStartDateDesc(); // aktif iş ilanları tarihe göre
                                                                              // listelenebilmelidir

    DataResult<List<JobAdvertisement>> getByStatusTrueOrderByStartDateAsc(); // aktif iş ilanları tarihe göre
                                                                             // listelenebilmelidir

    DataResult<List<JobAdvertisement>> getByOrderByStartDate();

    DataResult<List<JobAdvertisement>> getByOrderByStartDateAsc();

    DataResult<List<JobAdvertisement>> getByOrderByStartDateDesc();

    DataResult<List<JobAdvertisement>> getByOrderByEndDate();

    DataResult<List<JobAdvertisement>> getByOrderByEndDateAsc();

    DataResult<List<JobAdvertisement>> getByOrderByEndDateDesc();

    DataResult<List<JobAdvertisement>> getAllBySalaryBetween(int min, int max);

    DataResult<List<JobAdvertisement>> getByJobPosition_TitleContains(String jobName);

    Result updateJobAdvertisementStatus(int id, boolean selectedStatus);
}
