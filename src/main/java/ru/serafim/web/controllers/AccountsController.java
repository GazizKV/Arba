package ru.serafim.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.serafim.web.dto.AccountDto;
import ru.serafim.web.services.AccountService;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/accounts")
@Slf4j
public class AccountsController {

    private final AccountService accountService;

    @GetMapping
    public String getAccountsPage(Model model) {
        List<AccountDto> allAccounts = accountService.findAllAccounts();
        model.addAttribute("accounts", allAccounts);
        return "/accounts";
    }

    @PostMapping("/{account-id}/delete")
    public String deleteAccount(@PathVariable("account-id") Long accountId) {
        accountService.delete(accountId);
        return "redirect:/accounts";
    }
}
