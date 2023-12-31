package com.hrms.cmse406.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "skills")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private int skillId;


    @NotNull
    @NotBlank
    @Column(name = "description")
    private String description;

   @JsonIgnore
//    @ManyToMany()
//    @JoinColumn(name = "cv_id")
    @ManyToMany(mappedBy = "skills")
    private List<Cv> cvs;
}
