package ru.serafim.web.services;

// Created by IntelliJ IDEA.
// User: valit
// Date: 13.11.2021
// Time: 16:37
// Project name: serafim
// To change this template use File | Settings | File Templates.


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.serafim.web.models.FilesMetaData;
import ru.serafim.web.repositories.FilesMetaDataRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private FilesMetaDataRepository filesMetaDataRepository;

    private Path STORAGE_PATH;

    @Autowired
    public FileUploadServiceImpl(FilesMetaDataRepository filesMetaDataRepository) {
        this.filesMetaDataRepository = filesMetaDataRepository;
        try {
            if(!(new File("Storage")).exists())
                STORAGE_PATH = Files.createDirectory(Paths.get("Storage"));
            STORAGE_PATH = Paths.get("Storage");
        } catch (IOException e) {
            System.out.println("Storage folder can not created.");
            e.printStackTrace();
        }
    }

    @Override
    public void upload(MultipartFile file) {
        FilesMetaData filesMetaData = FilesMetaData.builder()
                .contentType(file.getContentType())
                .originalFileName(file.getOriginalFilename())
                .size(file.getSize())
                .storageFileName(UUID.randomUUID().toString())
                .build();

        filesMetaDataRepository.save(filesMetaData);

        try {
            Files.copy(file.getInputStream(), STORAGE_PATH.resolve(filesMetaData.getStorageFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
