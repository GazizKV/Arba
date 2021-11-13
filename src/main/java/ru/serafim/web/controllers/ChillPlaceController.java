package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.services.ChillPlacesService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chillPlaces")
public class ChillPlaceController {

    private final ChillPlacesService chillPlacesService;

    @GetMapping
    public String getRests(Model model) {
        model.addAttribute("chillPlaces", chillPlacesService.getAllRestPlases());
        return "chillPlaces";
    }

    @PostMapping("/{chillPlace-name}/select")
    public String getResult(@PathVariable("chillPlace-name") String name, Model model) {
        ChillPlaceDto chillPlaceDto = chillPlacesService.getChillPlaceByName(name);
        model.addAttribute("restPlace", chillPlaceDto);
        return "redirect:/chillPlace";
    }

}
