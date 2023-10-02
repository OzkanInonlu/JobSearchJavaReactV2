package com.hrms.cmse406.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.cmse406.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {
	
	//void deleteByCityId(int id);
	
	City findByCityId(int id);

}
