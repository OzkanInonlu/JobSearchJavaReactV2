package com.hrms.cmse406.dataAccess.abstracts;

import com.hrms.cmse406.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDao extends JpaRepository<Image, Integer> {

    List<Image> getAllByJobSeeker_Id(int jobSeekerId);

    //void deleteByImageId(int imageId);

    Image findByJobSeeker_Id(int candidateId);

}
