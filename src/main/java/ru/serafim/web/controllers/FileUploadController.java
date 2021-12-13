package ru.serafim.web.controllers;

// Created by IntelliJ IDEA.
// User: valit
// Date: 13.11.2021
// Time: 10:20
// Project name: serafim
// To change this template use File | Settings | File Templates.

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.serafim.web.services.AccountService;
import ru.serafim.web.services.FileUploadService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {

    private final FileUploadService fileUploadService;

    private final AccountService accountService;

    @GetMapping
    public String getMapping() {
        return "/fileUpload";
    }

    @PostMapping
    public String fileUpload(@RequestParam("file") MultipartFile file,
                             @RequestParam("description") String description,
                             Long id, Model model) {
        if(accountService.getAccountById(id).isPresent()) {
            fileUploadService.upload(file, description, id);
            model.addAttribute("Message", "File loaded successfully");
        }
        model.addAttribute("Message", "File loaded unsuccessfully, wrong id");
        return "/loadedFile";
    }
}