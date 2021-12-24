package ru.serafim.web.controllers;

//  author:  ValitovGaziz
//  date:    20.12.2021
//  project: serafim

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.services.ChillPlacesService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/addChillPlace")
@Slf4j
public class AddChillPlace {

    private final ChillPlacesService chillPlacesService;

    @GetMapping
    public String getAddChillPlace(Model model) {
        model.addAttribute("uploadMessage", "Nothing loaded");
        model.addAttribute("chillPlaceDto", new ChillPlaceDto());
        return "/addChillPlace";
    }

    @PostMapping("/insertIntoDataBaseNewChillPlace")
    public String insertNewChillPlace(ChillPlaceDto chillPlaceDto, Model model, CsrfToken token) {
        log.info("ChillPlaceDto is {}", chillPlaceDto.toString());
        log.info("token {}", token.toString());
        chillPlaceDto.setServiceRate(5);    // set the average service rate
        String save = chillPlacesService.save(chillPlaceDto);
        model.addAttribute("chillPlaceDto", new ChillPlaceDto());
        model.addAttribute("uploadMessage", save);
        return "/addChillPlace";
    }

    // TODO Add to chillPlaceDTO fields for contact and phones
}