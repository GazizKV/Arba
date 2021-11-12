package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.services.RestPlacesService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/restPlaces")
public class RestPlacesController {

    private final RestPlacesService restPlacesService;

    @GetMapping
    public String getRests(Model model) {
        model.addAttribute("restPlases", restPlacesService.getAllRestPlases());
        return "/restPlaces";
    }

    // In this place must be the post method))))
    @PostMapping
    public String getResult() {

    }

}
