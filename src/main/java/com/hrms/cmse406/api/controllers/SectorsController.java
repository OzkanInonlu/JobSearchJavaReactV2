package com.hrms.cmse406.api.controllers;

import com.hrms.cmse406.business.abstracts.SectorService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.Sector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sectors")
public class SectorsController {

    private SectorService sectorService;

    @Autowired
    public SectorsController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @PostMapping("/add")
    Result add(@RequestBody Sector sector){
        return this.sectorService.add(sector);
    }

    @GetMapping("/getall")
    DataResult<List<Sector>> getAll(){
        return this.sectorService.getAll();
    }
}
