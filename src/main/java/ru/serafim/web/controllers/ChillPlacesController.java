package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.services.ChillPlacesService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chillPlaces")
@Slf4j
public class ChillPlacesController {

    private final ChillPlacesService chillPlacesService;

    @GetMapping
    public String getRests(Model model) {
        model.addAttribute("chillPlaces", chillPlacesService.getAllRestPlases());
        model.addAttribute("chillPlaceDto", new ChillPlaceDto());
        return "chillPlaces";
    }

    @PostMapping("/insertIntoDataBaseNewChillPlace")
    public String inserNewChillPlace(ChillPlaceDto chillPlaceDto, Model model) {
        int i = 0;
        String name = chillPlaceDto.getName();
        model.addAttribute("chillPlaces", chillPlacesService.getAllRestPlases());
        model.addAttribute("chillPlaceDto", new ChillPlaceDto());
        return "/chillPlaces";
    }
}
