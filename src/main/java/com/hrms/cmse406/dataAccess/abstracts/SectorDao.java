package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectorDao extends JpaRepository<Sector, Integer> {
}
