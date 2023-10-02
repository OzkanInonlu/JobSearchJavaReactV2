package com.hrms.cmse406.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv_id")
    private int cvId;

    @NotNull
    @NotBlank
    @Column(name = "github_link")
    private String githubLink;

    @NotNull
    @NotBlank
    @Column(name = "linkedin_link")
    private String linkedinLink;


    // @DateTimeFormat(pattern = "MM-dd-yyyy")
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull
    @NotBlank
    @Column(name = "cover_letter")
    private String coverLetter;

    @NotNull
    @NotBlank
    @OneToOne()
    @JoinColumn(name = "job_seekers_job_seeker_id", referencedColumnName = "job_seeker_id")
    private JobSeeker jobSeeker;

//    @NotBlank
//    @ManyToMany()
//    @JoinColumn(name = "work_experience_id")
    @NotNull
    @NotBlank
	@ManyToMany()
	@JoinTable(
	  name = "cvs_work_experiences", 
	  joinColumns = @JoinColumn(name = "cv_id", referencedColumnName = "cv_id"), 
	  inverseJoinColumns = @JoinColumn(name = "work_experience_id", referencedColumnName = "work_experience_id"))
    private List<WorkExperience> workExperiences;

    @NotBlank
//    @ManyToMany()
//    @JoinColumn(name = "language_id")
    @NotNull
    @NotBlank
	@ManyToMany()
	@JoinTable(
	  name = "cvs_languages", 
	  joinColumns = @JoinColumn(name = "cv_id", referencedColumnName = "cv_id"), 
	  inverseJoinColumns = @JoinColumn(name = "language_id", referencedColumnName = "language_id"))
    private List<Language> languages;

   @NotBlank
//    @ManyToMany()
//    @JoinColumn(name = "ability_id")
    @NotNull
    @NotBlank
	@ManyToMany()
	@JoinTable(
	  name = "cvs_abilities", 
	  joinColumns = @JoinColumn(name = "cv_id", referencedColumnName = "cv_id"), 
	  inverseJoinColumns = @JoinColumn(name = "ability_id", referencedColumnName = "ability_id"))
    private List<Ability> abilities;

   @NotBlank
//    @ManyToMany()
//    @JoinColumn(name = "school_id")
//    private List<School> schools;
    @NotNull
    @NotBlank
	@ManyToMany()
	@JoinTable(
	  name = "cvs_schools", 
	  joinColumns = @JoinColumn(name = "cv_id", referencedColumnName = "cv_id"), 
	  inverseJoinColumns = @JoinColumn(name = "school_id", referencedColumnName = "school_id"))
	private List<School> schools;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "job_seeker_image_id")
    private Image image;

}
