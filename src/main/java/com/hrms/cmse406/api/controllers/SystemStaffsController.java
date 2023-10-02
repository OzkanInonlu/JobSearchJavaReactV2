package com.hrms.cmse406.api.controllers;

import com.hrms.cmse406.business.abstracts.SystemStaffService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.SystemStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/systemStaffs")
public class SystemStaffsController {

    private SystemStaffService systemStaffService;

    @Autowired
    public SystemStaffsController(SystemStaffService systemStaffService) {
        this.systemStaffService = systemStaffService;
    }

    @PostMapping("/add")
    Result add(@RequestBody SystemStaff systemStaff){
        return this.systemStaffService.add(systemStaff);
    }

    @GetMapping("/getall")
    DataResult<List<SystemStaff>> getAll(){
        return this.systemStaffService.getAll();
    }
}
