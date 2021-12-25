package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.models.Account;
import ru.serafim.web.models.ChillPlace;
import ru.serafim.web.security.details.AccountUserDetails;
import ru.serafim.web.services.ChillPlacesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class RootController {

    private final ChillPlacesService chillPlacesService;

    @GetMapping
    public String getRootPage(Authentication authentication, Model model) {
        Account account = ((AccountUserDetails) authentication.getPrincipal()).getAccount();
        Optional<List<ChillPlaceDto>> placeByAccountId = chillPlacesService.getChillPlaceByAccountId(account.getId());
        model.addAttribute("places", new ArrayList<ChillPlace>());
        if (placeByAccountId.isPresent() && (placeByAccountId.get().size() > 0)) {
            List<ChillPlaceDto> chillPlaces = placeByAccountId.get();
            model.addAttribute("places", chillPlaces);
        }
        model.addAttribute("account", account);
        return "/profile";
    }
}
