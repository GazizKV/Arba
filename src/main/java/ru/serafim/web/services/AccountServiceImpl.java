package ru.serafim.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.serafim.web.dto.AccountDto;
import ru.serafim.web.models.Account;
import ru.serafim.web.repositories.AccountsRepository;

import java.util.List;

import static ru.serafim.web.dto.AccountDto.from;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountsRepository accountsRepository;

    @Override
    public List<AccountDto> getAllAccounts() {
        return from(accountsRepository.findAllByStateNot(Account.State.DELETED));
    }

    @Override
    public void delete(Long accountId) {
        Account account = accountsRepository.getById(accountId);
        account.setState(Account.State.DELETED);
        accountsRepository.save(account);
    }
}
