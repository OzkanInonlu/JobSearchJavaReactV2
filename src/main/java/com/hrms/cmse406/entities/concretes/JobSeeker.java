package com.hrms.cmse406.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.hrms.cmse406.core.entities.concretes.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
@Table(name = "job_seekers")
public class JobSeeker extends User{

	/*
    @Id
    @GeneratedValue
    @Column(name = "job_seeker_id")
    private int jobSeekerId;
    */

    @NotNull
    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @NotBlank
    @Column(name = "last_name")
    private String lastName;

	@DateTimeFormat(pattern = "MM-dd-yyyy")
    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "^[1-9]{1}[0-9]{9}[02468]{1}$")
    @NotNull
    @NotBlank
    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "status")
    private boolean status;

    @NotNull
    @Column(name = "job_status")
    private boolean jobStatus;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    /*
    //@JsonIgnoreProperties({ "password", "status" })
    @OneToOne()
    @JoinColumn(name = "users_user_id", referencedColumnName = "user_id")
    private User user;
    */

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<JobApplication> jobApplications;

    // @JsonIgnore
    // @OneToMany(mappedBy = "jobSeeker")
    // private List<Image> images;

    @JsonIgnore
    @OneToOne(mappedBy = "jobSeeker")
    private Cv cv;
}