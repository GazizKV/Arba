package ru.serafim.web.services;

//  author:  ValitovGaziz
//  date:    14.12.2021
//  project: serafim

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.serafim.web.models.FilesMetaData;
import ru.serafim.web.repositories.FilesMetaDataRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final FilesMetaDataRepository filesMetaDataRepository;

    public List<FilesMetaData> getAllPhotoByPlaceId(Long id) {

        List<FilesMetaData> filesMetaDataList =
                filesMetaDataRepository.findAllByChillPlaceId(id);

        return filesMetaDataList;

    }

}
