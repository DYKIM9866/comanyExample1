package com.sparta.companyassignment1.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ImageHandler {
    public String save(MultipartFile image) throws IOException {
        if(image == null) return null;
        String fileName = image.getOriginalFilename();
        String fullPathName = "C:\\dev_study\\sparta\\companyAssignment\\companyAssignment1\\src\\main\\resources\\image"
                + LocalDateTime.now() + fileName;
        image.transferTo(new File(fullPathName));

        return fullPathName;
    }
}
