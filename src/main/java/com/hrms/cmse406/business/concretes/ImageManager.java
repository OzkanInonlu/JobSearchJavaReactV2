package com.hrms.cmse406.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import com.hrms.cmse406.business.abstracts.CvService;
import com.hrms.cmse406.business.abstracts.ImageService;
import com.hrms.cmse406.core.adapters.abstracts.CloudinaryService;
import com.hrms.cmse406.business.abstracts.JobSeekerService;
import com.hrms.cmse406.core.adapters.abstracts.CloudinaryService;
import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.ErrorDataResult;
import com.hrms.cmse406.core.utilities.results.ErrorResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessResult;
import com.hrms.cmse406.dataAccess.abstracts.CvDao;
import com.hrms.cmse406.dataAccess.abstracts.JobSeekerDao;
import com.hrms.cmse406.dataAccess.abstracts.ImageDao;
import com.hrms.cmse406.entities.concretes.JobSeeker;
import com.hrms.cmse406.entities.concretes.Cv;
import com.hrms.cmse406.entities.concretes.Image;
import lombok.experimental.var;

@Service
public class ImageManager implements ImageService {

    private ImageDao imageDao;
    private CloudinaryService cloudinaryService;
    private JobSeekerDao jobSeekerDao;
    private CvDao candidateCvDao;

    // @Autowired
    // private Cloudinary cloudinary;

    @Autowired
    public ImageManager(ImageDao imageDao, CloudinaryService cloudinaryService,
            JobSeekerDao jobSeekerDao, CvDao candidateCvDao) {
        super();
        this.imageDao = imageDao;
        this.cloudinaryService = cloudinaryService;
        this.jobSeekerDao = jobSeekerDao;
        this.candidateCvDao = candidateCvDao;
    }

    @Override
    public DataResult<List<Image>> getAll() {
        // TODO Auto-generated method stub
        return new SuccessDataResult<List<Image>>(this.imageDao.findAll(), "Data Listed");
    }
    //
    //
    //
    // @Override
    // public Result add(int candidateId, int candidateCvId, MultipartFile
    // multipartFile) {
    // // TODO Auto-generated method stub
    // try {
    // var result = this.cloudinaryFileService.upload(multipartFile);
    // CandidateImage candidateImage = new CandidateImage();
    // if (!result.isSuccess()) {
    // return new ErrorResult(result.getMessage());
    // }
    // if(multipartFile == null){
    // candidateImage.setImage("Image is not uploaded");
    // }
    // Candidate candidate = candidateDao.findById(candidateId);
    // CandidateCv candidateCv = candidateCvDao.findById(candidateCvId);
    //
    // candidateImage.setCandidate(candidate);
    //
    // String[] readList = {"pdf","txt","docx"};
    // String url = result.getData().get("url");
    //
    // candidateImage.setImage(multiFileValidation(url, readList, "png"));
    // candidateImageDao.save(candidateImage);
    //
    // candidateCv.setCandidateImage(candidateImage);
    // candidateCvDao.save(candidateCv);
    //
    // return new SuccessResult();
    // }catch (MethodArgumentTypeMismatchException | NoSuchElementException |
    // NullPointerException e){
    // return new ErrorResult();
    // }
    // }
    //
    // public String multiFileValidation(String data, String[] readList, String
    // replacement){
    // String newData = data;
    // for (String a: readList) {
    // newData = data.replace(a, replacement);
    // if (!newData.equals(data)) {
    // break;
    // }
    // }
    // return newData;
    // }

    @Override
    public Result upload(int candidateId, int candidateCvId, MultipartFile file) {

        try {
            DataResult<Map<String, String>> result = this.cloudinaryService.upload(file);
            Image candidateImage = new Image();
            if (!result.isSuccess()) {
                return new ErrorResult(result.getMessage());
            }
            if (file == null) {
                candidateImage.setPhotoUrl("Image is not uploaded");
            }
            JobSeeker jobSeeker = jobSeekerDao.getByJobSeekerId(candidateId);
            Cv candidateCv = candidateCvDao.findByCvId(candidateCvId);

            if (imageDao.findByJobSeeker_JobSeekerId(candidateId) != null) {
                return new ErrorResult("Photo has been already uploaded before");
            }

            candidateImage.setJobSeeker(jobSeeker);

            String[] readList = { "pdf", "txt", "docx" };
            String url = result.getData().get("url");

            candidateImage.setPhotoUrl(multiFileValidation(url, readList, "png"));
            imageDao.save(candidateImage);

            candidateCv.setImage(candidateImage);
            candidateCvDao.save(candidateCv);

            return new SuccessResult(result.getMessage());
        } catch (MethodArgumentTypeMismatchException | NoSuchElementException | NullPointerException e) {
            return new ErrorResult(e.getMessage());
        }

        //
        // try {
        // return new SuccessDataResult<Map>
        // (this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap()),
        // "Photo Uploaded");
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // throw new RuntimeException("Image uploading fail");
        // }

    }

    public String multiFileValidation(String data, String[] readList, String replacement) {
        String newData = data;
        for (String a : readList) {
            newData = data.replace(a, replacement);
            if (!newData.equals(data)) {
                break;
            }
        }
        return newData;
    }

}
