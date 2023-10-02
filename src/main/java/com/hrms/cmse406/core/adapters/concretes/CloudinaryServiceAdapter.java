package com.hrms.cmse406.core.adapters.concretes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import java.util.*;

import com.hrms.cmse406.core.adapters.abstracts.CloudinaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.ErrorDataResult;
import com.hrms.cmse406.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryServiceAdapter implements CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public DataResult<Map<String, String>> upload(MultipartFile multipartFile) {
        // TODO Auto-generated method stub
        File file;
        try {
            file = convert(multipartFile);
            Map<String, String> result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            file.delete();
            return new SuccessDataResult<Map<String, String>>(result, "File is uploaded");
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<Map<String, String>>("File could not be uploaded");
        }
    }

    @Override
    public DataResult<Map> delete(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    private static File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }

}
