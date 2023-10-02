package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.SystemStaff;

import java.util.List;

public interface SystemStaffService {

    Result add(SystemStaff systemStaff);

    DataResult<List<SystemStaff>> getAll();

}
