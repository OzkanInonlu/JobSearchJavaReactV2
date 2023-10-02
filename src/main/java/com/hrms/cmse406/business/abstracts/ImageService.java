package com.hrms.cmse406.business.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import com.hrms.cmse406.core.utilities.results.Result;
import com.hrms.cmse406.entities.concretes.Image;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    DataResult<List<Image>> getAll();

    // Result add(int candidateId, int candidateCvId, MultipartFile multipartFile);

    Result upload(int candidateId, int candidateCvId, MultipartFile file);

}
