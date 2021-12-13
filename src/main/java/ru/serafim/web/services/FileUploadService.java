package ru.serafim.web.services;

// Created by IntelliJ IDEA.
// User: valit
// Date: 14.11.2021
// Time: 12:34
// Project name: serafim
// To change this template use File | Settings | File Templates.


import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    String upload(MultipartFile file, String description, Long id);
}
