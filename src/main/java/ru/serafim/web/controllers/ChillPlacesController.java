package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.services.ChillPlacesService;
import ru.serafim.web.services.FileUploadService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chillPlaces")
@Slf4j
public class ChillPlacesController {

    private final ChillPlacesService chillPlacesService;

    private final FileUploadService fileUploadService;

    @GetMapping
    public String getRests(Model model) {
        List<ChillPlaceDto> allRestPlaces = chillPlacesService.getAllRestPlases();
        model.addAttribute("chillPlaces", allRestPlaces);
        model.addAttribute("chillPlaceDto", new ChillPlaceDto());
        model.addAttribute("uploadMessage", "Empty");
        log.info("allRestPlaces {}", allRestPlaces);
        return "/chillPlaces";
    }

    @PostMapping("/search")
    public String getSearchRequest(Model model,
                                   @RequestParam("searchString") String searchString) {
        List<ChillPlaceDto> allRestPlaces = chillPlacesService.getAllRestPlases();
        model.addAttribute("chillPlaceDto", new ChillPlaceDto());
        model.addAttribute("uploadMessage", "Nothing for load");
        if(!(searchString == null)) {
            List<ChillPlaceDto> filteredChillPlaces = new ArrayList<>();
            for (ChillPlaceDto place : allRestPlaces) {
                if (place.getName().contains(searchString)) filteredChillPlaces.add(place);
            }
            model.addAttribute("chillPlaces", filteredChillPlaces);
            return "/chillPlaces";
        }
        model.addAttribute("chillPlaces", allRestPlaces);
        return "/chillPlaces";
    }

    @PostMapping("/insertIntoDataBaseNewChillPlace")
    public String insertNewChillPlace(ChillPlaceDto chillPlaceDto, Model model) {
        log.info("chillplaceDto is {}", chillPlaceDto.toString());
        chillPlaceDto.setServiceRate(5);    // set the average service rate
        chillPlacesService.save(chillPlaceDto);
        model.addAttribute("chillPlaces", chillPlacesService.getAllRestPlases());
        model.addAttribute("chillPlaceDto", new ChillPlaceDto());
        model.addAttribute("uploadMessage", "Nothing for load");
        return "/chillPlaces";
    }

    @PostMapping("/{chillPlace_id}/delete")
    public String deletePlace(@PathVariable("chillPlace_id") Long id, Model model) {
        chillPlacesService.deleteById(id);
        List<ChillPlaceDto> allRestPlases = chillPlacesService.getAllRestPlases();
        model.addAttribute("chillPlaces", allRestPlases);
        model.addAttribute("chillPlaceDto", new ChillPlaceDto());
        model.addAttribute("uploadMessage", "Nothing for load");
        return "/chillPlaces";
    }

    @PostMapping("/upLoadPhoto/{chillPlace_id}")
    public String upLoadPhoto(@PathVariable("chillPlace_id") Long id,
                              @RequestParam("file") MultipartFile file,
                              @RequestParam("description") String description,
                              Model model) {
        String upload = fileUploadService.upload(file, description, id);
        List<ChillPlaceDto> allRestPlaces = chillPlacesService.getAllRestPlases();
        model.addAttribute("chillPlaces", allRestPlaces);
        model.addAttribute("chillPlaceDto", new ChillPlaceDto());
        model.addAttribute("uploadMessage", upload);
        return "/chillPlaces";
    }
}