package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.JobAdvertisementService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.ErrorResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.JobAdvertisementDao;
import com.hrms.cmse406.entities.concretes.Cv;
import com.hrms.cmse406.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.findAll(), "Data Listed");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("Job advert added");
    }
    
    
	@Override
	public Result deleteById(int id) {
		
		JobAdvertisement ja = jobAdvertisementDao.findByJobAdvertisementId(id);
		if(ja != null) {
			jobAdvertisementDao.deleteById(id);
			return new SuccessResult("Job advert is removed");
		}
		return new ErrorResult("Job advert not found");
	}


    @Override
    public DataResult<List<JobAdvertisement>> getAllByCity_NameContains(String name) {
        return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getAllByCity_NameContains(name), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByStatus(boolean status) {
        return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getAllByStatus(status), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllByEmployer_CompanyNameAndStatus(String companyName,
            boolean status) {
          return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getAllByEmployer_CompanyNameAndStatus(companyName, status), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusTrue() {
         return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getByStatusTrue(), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusTrueOrderByStartDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getByStatusTrueOrderByStartDateDesc(), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusTrueOrderByStartDateAsc() {
        return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getByStatusTrueOrderByStartDateAsc(), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByOrderByStartDate() {
        return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getByOrderByStartDate(), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByOrderByStartDateAsc() {
        return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getByOrderByStartDateAsc(), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByOrderByStartDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getByOrderByStartDateDesc(), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByOrderByEndDate() {
        return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getByOrderByEndDate(), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByOrderByEndDateAsc() {
        return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getByOrderByEndDateAsc(), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByOrderByEndDateDesc() {
        return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getByOrderByEndDateDesc(), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllBySalaryBetween(int min, int max) {
        return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getAllBySalaryBetween(min, max), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByJobPosition_TitleContains(String jobName) {
        return new SuccessDataResult<List<JobAdvertisement>>
        (this.jobAdvertisementDao.getByJobPosition_TitleContains(jobName), "Data Listed");
    }

    @Override
    public Result updateJobAdvertisementStatus(int id, boolean selectedStatus) {
        this.jobAdvertisementDao.updateJobAdvertisementStatus(id, selectedStatus);
		return new SuccessResult("Selected Job Advertisement is " + (selectedStatus? "opened." : "closed."));
    }


}
