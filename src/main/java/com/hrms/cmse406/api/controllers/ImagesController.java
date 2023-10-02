package com.hrms.cmse406.api.controllers;

import com.hrms.cmse406.business.abstracts.ImageService;
import com.hrms.cmse406.business.abstracts.JobSeekerService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.Image;
import com.hrms.cmse406.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImagesController {

    private ImageService imageService;

    @Autowired
    public ImagesController(ImageService imageService) {
        super();
        this.imageService = imageService;
    }

    // @PostMapping("/add")
    // public Result add(int candidateId, int candidateCvId, MultipartFile
    // multipartFile) {
    // return this.candidateImageService.add(candidateId, candidateCvId,
    // multipartFile);
    // }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam int candidateId, @RequestParam int candidateCvId,
            @RequestParam MultipartFile file) {

        return ResponseEntity.ok(this.imageService.upload(candidateId, candidateCvId, file));

    }

    @GetMapping("/getAll")
    public DataResult<List<Image>> getAll() {
        return this.imageService.getAll();
    }

}
