package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.dto.ChillPlaceDto;
import ru.serafim.web.models.Account;
import ru.serafim.web.models.ChillPlace;
import ru.serafim.web.security.details.AccountUserDetails;
import ru.serafim.web.services.AccountService;
import ru.serafim.web.services.ChillPlacesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final AccountService accountService;

    private final ChillPlacesService chillPlacesService;

    @RequestMapping()
    public String getProfilePage(Model model, Authentication authentication) {
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

    //  TODO Сделать скрытой или не скрытой кнопку перехода на
    //   панель для редактирования аккаунтов в зависимости от роли
    //   пользователя(Account)

    // TODO Сделать подтверждение созданного места через почьту аккунта.

    // TODO Сделать подтверждение зарегистрированного аккаунта через имаил.
}
