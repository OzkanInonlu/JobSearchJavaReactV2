package com.hrms.cmse406.entities.dtos;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.hrms.cmse406.entities.concretes.Image;
import com.hrms.cmse406.entities.concretes.JobSeeker;
import com.hrms.cmse406.entities.concretes.Language;
import com.hrms.cmse406.entities.concretes.School;
import com.hrms.cmse406.entities.concretes.Skill;
import com.hrms.cmse406.entities.concretes.WorkExperience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvWithAllDetailsDto {
	
	private int cvId;

	private LocalDateTime createdAt;

	private JobSeeker jobSeeker;

	private String cover;
	
	private List<String> links;

	private Image image;

	private List<School> schools;

	private List<WorkExperience> workExperiences;

	private List<Language> languages;

	private List<Skill> skills;
    
    

}
