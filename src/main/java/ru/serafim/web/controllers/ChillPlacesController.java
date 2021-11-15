package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.services.ChillPlacesService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chillPlaces")
public class ChillPlacesController {

    private final ChillPlacesService chillPlacesService;

    @GetMapping
    public String getRests(Model model) {
        model.addAttribute("chillPlaces", chillPlacesService.getAllRestPlases());
        return "chillPlaces";
    }

    @PostMapping("/insertIntoDataBaseNewChillPlace")
    public String inserNewChillPlace(Model model) {
        int i = 0;
        return "/chillPlaces";
    }

}
