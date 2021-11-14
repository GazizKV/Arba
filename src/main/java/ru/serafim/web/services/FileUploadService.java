package ru.serafim.web.services;

// Created by IntelliJ IDEA.
// User: valit
// Date: 13.11.2021
// Time: 16:37
// Project name: serafim
// To change this template use File | Settings | File Templates.


import lombok.RequiredArgsConstructor;
import org.springframework.http.codec.multipart.Part;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FileUploadService {

    public void upload(MultipartFile file) {
        System.out.println(file.getName() + "file for upload)" + file.getOriginalFilename());
    }
}
