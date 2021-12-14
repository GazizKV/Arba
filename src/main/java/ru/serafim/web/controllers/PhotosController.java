package ru.serafim.web.controllers;

//  author:  ValitovGaziz
//  date:    14.12.2021
//  project: serafim

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.models.FilesMetaData;
import ru.serafim.web.services.PhotoServiceImpl;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/photo")
public class PhotosController {

    private final PhotoServiceImpl photoService;

    @GetMapping("/getPhoto/{place_id}")
    public String getPhotos(
            @PathVariable("place_id") Long id,
            Model model) {
        List<FilesMetaData> filesMetaDataList = photoService.getAllPhotoByPlaceId(id);
        return "photo";
    }

}
