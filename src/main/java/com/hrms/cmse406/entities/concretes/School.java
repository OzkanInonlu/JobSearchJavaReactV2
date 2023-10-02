package com.hrms.cmse406.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private int schoolId;

    @NotNull
    @NotBlank
    @Column(name = "school_name")
    private String schoolName;

    @NotNull
    @NotBlank
    @Column(name = "department")
    private String department;

    @NotNull
    @NotBlank
    @Column(name = "education_start_date")
    private LocalDate educationStartDate;

    @NotNull
    @NotBlank
    @Column(name = "is_graduate")
    private boolean isGraduate;

    @NotNull
    @NotBlank
    @Column(name = "graduate_date")
    private LocalDate graduateDate;

    @JsonIgnore
//    @ManyToMany()
//    @JoinColumn(name = "cv_id")
    @ManyToMany(mappedBy = "schools")
    private List<Cv> cvs;
}
