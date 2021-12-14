package ru.serafim.web.services;

//  author:  ValitovGaziz
//  date:    14.12.2021
//  project: serafim

import ru.serafim.web.models.FilesMetaData;

import java.util.List;

public interface PhotoService {
    List<FilesMetaData> getAllPhotoByPlaceId(Long id);
}