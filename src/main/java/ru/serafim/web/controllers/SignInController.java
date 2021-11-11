package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/signIn")
public class SignInController {

    @GetMapping()
    public String getProfilePage(Authentication authentication) {
        if(authentication != null) {
            return "redirect:/";
        }
        return "/signIn";
    }
}