package com.hrms.cmse406.entities.dtos;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.hrms.cmse406.entities.concretes.School;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvWithSchoolDetails {
	
	private int cvId;
    private Collection<School> schools;
    
    

}
