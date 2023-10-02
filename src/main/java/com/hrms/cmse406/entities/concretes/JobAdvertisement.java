package com.hrms.cmse406.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
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
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_advertisement_id")
    private int jobAdvertisementId;

    @NotNull
    @NotBlank
    @Column(name = "description")
	private String description;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
	@Column(name = "start_date")
	private LocalDate startDate = LocalDate.now();

    @NotNull
    @NotBlank
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Column(name = "end_date")
	private LocalDate endDate;

    @NotNull
    @NotBlank
	@Column(name = "max_salary")
	private double maxSalary;

    @NotNull
    @NotBlank
	@Column(name = "min_salary")
	private double minSalary;

    @NotNull
    @NotBlank
	@Column(name = "free_position_amount")
	private int freePositionAmount;

    @NotNull
    @NotBlank
    @Column(name = "status")
    private boolean status;

    @NotNull
    @NotBlank
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;

    @NotNull
    @NotBlank
    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @NotNull
    @NotBlank
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;

    @NotNull
    @NotBlank
    @ManyToOne()
    @JoinColumn(name = "sector_id")
    private Sector sector;

    @JsonIgnore
    @OneToMany(mappedBy = "jobAdvertisement")
    private List<JobApplication> jobApplications;
}
