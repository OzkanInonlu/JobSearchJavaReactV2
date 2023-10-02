package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.Sector;

import java.util.List;

public interface SectorService {

    Result add(Sector sector);

    DataResult<List<Sector>> getAll();

}
