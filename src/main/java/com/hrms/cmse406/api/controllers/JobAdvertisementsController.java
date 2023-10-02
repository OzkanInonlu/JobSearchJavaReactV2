package com.hrms.cmse406.api.controllers;

import com.hrms.cmse406.business.abstracts.JobAdvertisementService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService=jobAdvertisementService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }
    
    
    @DeleteMapping("/deleteById")
    public Result deleteById(@RequestParam int id) {
        return this.jobAdvertisementService.deleteById(id);
    }

    @GetMapping("/getAllByCity_Name")
    public DataResult<List<JobAdvertisement>> getAllByCity_NameContains(@RequestParam String name) {
        return this.jobAdvertisementService.getAllByCity_NameContains(name);
    }

    @GetMapping("/getAllByStatus")
    public DataResult<List<JobAdvertisement>> getAllByStatus(@RequestParam boolean status) {
        return this.jobAdvertisementService.getAllByStatus(status);
    }

    @GetMapping("/getAllByEmployer_CompanyNameAndStatus")
    public DataResult<List<JobAdvertisement>> getAllByEmployer_CompanyNameAndStatus(String companyName,
            boolean status) {
        return this.jobAdvertisementService.getAllByEmployer_CompanyNameAndStatus(companyName, status);
    }

    @GetMapping("/getByStatusTrue")
    public DataResult<List<JobAdvertisement>> getByStatusTrue() {
        return this.jobAdvertisementService.getByStatusTrue();
    }

    @GetMapping("/getByStatusTrueOrderByStartDateDesc")
    public DataResult<List<JobAdvertisement>> getByStatusTrueOrderByStartDateDesc() {
           return this.jobAdvertisementService.getByStatusTrueOrderByStartDateDesc();
    }

    @GetMapping("/getByStatusTrueOrderByStartDateAsc")
    public DataResult<List<JobAdvertisement>> getByStatusTrueOrderByStartDateAsc() {
         return this.jobAdvertisementService.getByStatusTrueOrderByStartDateAsc();
    }

    @GetMapping("/getByOrderByStartDate")
    public DataResult<List<JobAdvertisement>> getByOrderByStartDate() {
        return this.jobAdvertisementService.getByOrderByStartDate();
    }

    @GetMapping("/getByOrderByStartDateAsc")
    public DataResult<List<JobAdvertisement>> getByOrderByStartDateAsc() {
        return this.jobAdvertisementService.getByOrderByStartDateAsc();
    }

    @GetMapping("/getByOrderByStartDateDesc")
    public DataResult<List<JobAdvertisement>> getByOrderByStartDateDesc() {
        return this.jobAdvertisementService.getByOrderByStartDateDesc();
    }

    @GetMapping("/getByOrderByEndDate")
    public DataResult<List<JobAdvertisement>> getByOrderByEndDate() {
        return this.jobAdvertisementService.getByOrderByEndDate();
    }

    @GetMapping("/getByOrderByEndDateAsc")
    public DataResult<List<JobAdvertisement>> getByOrderByEndDateAsc() {
         return this.jobAdvertisementService.getByOrderByEndDateAsc();
    }

    @GetMapping("/getByOrderByEndDateDesc")
    public DataResult<List<JobAdvertisement>> getByOrderByEndDateDesc() {
        return this.jobAdvertisementService.getByOrderByEndDateDesc();
    }

    @GetMapping("/getAllBySalaryBetween")
    public DataResult<List<JobAdvertisement>> getAllBySalaryBetween(@RequestParam int min, @RequestParam int max) {
        return this.jobAdvertisementService.getAllBySalaryBetween(min, max);
    }

    @GetMapping("/getByJobPosition_TitleContains")
    public DataResult<List<JobAdvertisement>> getByJobPosition_TitleContains(String jobName) {
        return this.jobAdvertisementService.getByJobPosition_TitleContains(jobName);
    }

    @PostMapping("/updateJobAdvertisementStatusById")
    public Result updateJobAdvertisementStatus(int id, boolean selectedStatus) {
        return this.jobAdvertisementService.updateJobAdvertisementStatus(id, selectedStatus);
    }

}
