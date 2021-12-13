package ru.serafim.web.services;

import ru.serafim.web.dto.AccountDto;
import ru.serafim.web.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<AccountDto> getAllAccounts();

    void delete(Long accountId);

    Optional<Account> getAccountById(Long id);
}
