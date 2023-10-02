package com.hrms.cmse406.business.concretes;

import com.hrms.cmse406.business.abstracts.SectorService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.SectorDao;
import com.hrms.cmse406.entities.concretes.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorManager implements SectorService {

    private SectorDao sectorDao;

    @Autowired
    public SectorManager(SectorDao sectorDao) {
        this.sectorDao = sectorDao;
    }

    @Override
    public Result add(Sector sector) {
        this.sectorDao.save(sector);
        return new SuccessResult("Sector is added");
    }

    @Override
    public DataResult<List<Sector>> getAll() {
        return new SuccessDataResult<List<Sector>>(this.sectorDao.findAll(), "Data Listed");
    }
}
