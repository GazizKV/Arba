package ru.serafim.web.controllers;

//  author:  ValitovGaziz
//  date:    26.12.2021
//  project: serafim

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.services.ChillPlacesService;
import ru.serafim.web.services.FileUploadService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/editPlace")
public class EditPlaceController {


    private final ChillPlacesService chillPlacesService;

    private final FileUploadService fileUploadService;

    @PostMapping("/get/{place_id}")
    public String editPlace(@PathVariable("place_id") Long placeId, Model model) {
        ChillPlaceDto chillPlaceDto = chillPlacesService.getChillPlaceById(placeId);
        model.addAttribute("place", chillPlaceDto);
        model.addAttribute("uploadMessage", "Nothing is uploaded");
        return "/editPlace";
    }

    @PostMapping("/upLoadPhoto/{chillPlace_id}")
    public String upLoadPhoto(@PathVariable("chillPlace_id") Long id,
                              @RequestParam("file") MultipartFile file,
                              @RequestParam("description") String description,
                              Model model) {
        String upload = fileUploadService.upload(file, description, id);
        ChillPlaceDto chillPlaceDto = chillPlacesService.getChillPlaceById(id);
        model.addAttribute("place", chillPlaceDto);
        model.addAttribute("uploadMessage", upload);
        return "/chillPlace";
    }

    @PostMapping("/delete/{chillPlace_id}")
    public String deletePlace(@PathVariable("chillPlace_id") Long id, Model model) {
        String deleteByIdMessage = chillPlacesService.deleteById(id);
        List<ChillPlaceDto> allRestPlaces = chillPlacesService.getAllRestPlases();
        model.addAttribute("chillPlaces", allRestPlaces);
        model.addAttribute("deleteByIdMessage", deleteByIdMessage);
        return "redirect:/profile";
    }

}
