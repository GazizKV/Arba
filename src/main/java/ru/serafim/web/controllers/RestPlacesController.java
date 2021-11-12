package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.dto.RestingPlaceDto;
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

    @PostMapping("/{restPlace-name}/select")
    public String getResult(@PathVariable("restPlace-name") String email, Model model) {
        RestingPlaceDto restPlaceDto = restPlacesService.getRestPlaceByName(email);
        model.addAttribute("restPlace", restPlaceDto);
        return "redirect:/restPlace";
    }

}
