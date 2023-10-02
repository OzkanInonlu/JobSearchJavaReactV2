package com.hrms.cmse406.core.adapters.abstracts;

import com.hrms.cmse406.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

public interface CloudinaryService {
    DataResult<Map<String, String>> upload(MultipartFile multipartFile);

    DataResult<Map> delete(String id);
}
