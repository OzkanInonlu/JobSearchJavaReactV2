package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.SystemStaffService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.SystemStaffDao;
import com.hrms.cmse406.entities.concretes.SystemStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemStaffManager implements SystemStaffService {

    private SystemStaffDao systemStaffDao;

    @Autowired
    public SystemStaffManager(SystemStaffDao systemStaffDao) {
        this.systemStaffDao = systemStaffDao;
    }

    @Override
    public Result add(SystemStaff systemStaff) {
        this.systemStaffDao.save(systemStaff);
        return new SuccessResult("Admin is added");
    }

    @Override
    public DataResult<List<SystemStaff>> getAll() {
        return new SuccessDataResult<List<SystemStaff>>(this.systemStaffDao.findAll(), "Data Listed");
    }
}
