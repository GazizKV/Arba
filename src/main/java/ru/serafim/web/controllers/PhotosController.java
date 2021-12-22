package ru.serafim.web.controllers;

//  author:  ValitovGaziz
//  date:    14.12.2021
//  project: serafim

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.models.FilesMetaData;
import ru.serafim.web.services.PhotoServiceImpl;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/photo")
@Slf4j
public class PhotosController {

    private final PhotoServiceImpl photoService;

    private Path STORAGE_PATH;

    @GetMapping("/getPhoto/{place_id}")
    public String getPhotos(
            @PathVariable("place_id") Long id,
            Model model) {
        List<FilesMetaData> filesMetaDataList = photoService.getAllPhotoByPlaceId(id);
        try {
            if (!(new File("Storage")).exists())
                STORAGE_PATH = Files.createDirectory(Paths.get("Storage"));
            STORAGE_PATH = Paths.get("Storage");
        } catch (IOException e) {
            System.out.println("Storage folder can not created.");
            e.printStackTrace();
        }
        List<InputStream> inputStreams = new ArrayList<>();
        for (FilesMetaData filesMetaData : filesMetaDataList) {
            try {
                inputStreams.add(new FileInputStream(STORAGE_PATH + "/" + filesMetaData.getStorageFileName()));
            } catch (FileNotFoundException e) {
                log.debug("Error writing file to output stream. Filename was {}", filesMetaData.getStorageFileName());
                e.printStackTrace();
            }
        }
        model.addAttribute("streamList", inputStreams);
        return "photo";
    }

    //  TODO Тут надо все переделать так что бы все работало)) а то совсем ни чего не работает
}
