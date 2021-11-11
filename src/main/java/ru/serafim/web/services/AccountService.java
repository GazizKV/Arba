package ru.serafim.web.services;

import ru.serafim.web.dto.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAllAccounts();

    void delete(Long accountId);
}
