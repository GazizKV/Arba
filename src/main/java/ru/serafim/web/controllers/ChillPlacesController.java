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

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chillPlaces")
@Slf4j
public class ChillPlacesController {

    private final ChillPlacesService chillPlacesService;

    @GetMapping
    public String getRests(Model model) {
        List<ChillPlaceDto> allRestPlases = chillPlacesService.getAllRestPlases();
        model.addAttribute("chillPlaces", allRestPlases);
        model.addAttribute("chillPlaceDto", new ChillPlaceDto());
        log.info("allRastPlases {}", allRestPlases);
        return "chillPlaces";
    }

    @PostMapping("/insertIntoDataBaseNewChillPlace")
    public String insertNewChillPlace(ChillPlaceDto chillPlaceDto, Model model) {
        log.info("chillplaceDto is {}", chillPlaceDto.toString());
        chillPlaceDto.setServiceRate(5);    // set the average service rate
        chillPlacesService.save(chillPlaceDto);
        model.addAttribute("chillPlaces", chillPlacesService.getAllRestPlases());
        model.addAttribute("chillPlaceDto", new ChillPlaceDto());
        return "/chillPlaces";
    }
}
