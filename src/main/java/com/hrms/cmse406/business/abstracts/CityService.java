package com.hrms.cmse406.business.abstracts;

import java.util.List;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.City;

public interface CityService {
	
    Result add(City city);

    DataResult<List<City>> getAll();
    
    Result deleteByCityId(int id);


}
