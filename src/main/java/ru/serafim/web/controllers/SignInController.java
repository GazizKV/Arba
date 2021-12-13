package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/signIn")
@Slf4j
public class SignInController {

    @GetMapping()
    public String getProfilePage(Authentication authentication) {
        log.info("Authentication {}", authentication);
        if(authentication != null) {
            return "redirect:/";
        }
        return "/signIn";
    }
}