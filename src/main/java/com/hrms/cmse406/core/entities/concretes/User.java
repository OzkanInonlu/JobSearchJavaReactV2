package com.hrms.cmse406.core.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import com.hrms.cmse406.entities.concretes.Employer;
import com.hrms.cmse406.entities.concretes.JobSeeker;
import com.hrms.cmse406.entities.concretes.SystemStaff;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Email
    @NotNull
    @NotBlank
    @Column(name = "email")
    private String email;

    @NotNull
    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private boolean status;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private JobSeeker jobSeeker;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private Employer employer;

    @JsonIgnore
    @OneToOne(mappedBy = "user")
    private SystemStaff systemStaff;
}