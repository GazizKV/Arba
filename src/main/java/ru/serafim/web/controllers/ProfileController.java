package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.repositories.AccountsRepository;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final AccountsRepository accountsRepository;

    @RequestMapping()
    public String getProfilePage(Model model) {
        return "profile";
    }

}
