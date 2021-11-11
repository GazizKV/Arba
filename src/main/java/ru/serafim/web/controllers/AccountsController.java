package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.services.AccountService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/accounts")
public class AccountsController {

    private final AccountService accountService;

    @GetMapping
    public String getAccountsPage(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "/accounts";
    }

    @PostMapping("/{account-id}/delete")
    public String deleteAccount(@PathVariable("account-id") Long accountId) {
        accountService.delete(accountId);
        return "redirect:/accounts";
    }
}
