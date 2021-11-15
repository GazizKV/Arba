package ru.serafim.web.controllers;

// developer:   Valitov Gaziz
// email:       valitovgaziz@gmail.com
// telegram:    @mrobena
// phone:       +7 (962) 543-93-43
// Date time:   14.11.2021 16:49
// Project:     serafim

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.services.ChillPlacesService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chillPlace")
public class ChillPlaceController {

    private final ChillPlacesService chillPlacesService;

    @PostMapping("/{chillPlace_id}/select")
    public String getResult(@PathVariable("chillPlace_id") Long id, Model model) {
        ChillPlaceDto chillPlaceDto = chillPlacesService.getChillPlaceById(id);
        model.addAttribute("place", chillPlaceDto);
        return "chillPlace";
    }
}
