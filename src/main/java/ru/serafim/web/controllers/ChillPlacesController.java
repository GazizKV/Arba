package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.services.ChillPlacesService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chillPlaces")
@Slf4j
public class ChillPlacesController {

    private final ChillPlacesService chillPlacesService;

    @GetMapping
    public String getRests(Model model) {
        List<ChillPlaceDto> allRestPlaces = chillPlacesService.getAllRestPlases();
        model.addAttribute("chillPlaces", allRestPlaces);
        return "/chillPlaces";
    }

    @PostMapping("/search")
    public String getSearchRequest(Model model,
                                   @RequestParam("searchString") String searchString) {
        List<ChillPlaceDto> allRestPlaces = chillPlacesService.getAllRestPlases();
        model.addAttribute("chillPlaces", allRestPlaces);
        if (!searchString.isBlank()) {
            List<ChillPlaceDto> filteredChillPlaces = new ArrayList<>();
            for (ChillPlaceDto place : allRestPlaces) {
                if (place.getName().contains(searchString)) filteredChillPlaces.add(place);
            }
            model.addAttribute("chillPlaces", filteredChillPlaces);
        }
        return "/chillPlaces";
    }


    @PostMapping("/{chillPlace_id}/delete")
    public String deletePlace(@PathVariable("chillPlace_id") Long id, Model model) {
        chillPlacesService.deleteById(id);
        List<ChillPlaceDto> allRestPlaces = chillPlacesService.getAllRestPlases();
        model.addAttribute("chillPlaces", allRestPlaces);
        return "/chillPlaces";
    }


}