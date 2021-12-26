package ru.serafim.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.serafim.web.dto.AccountDto;
import ru.serafim.web.models.Account;
import ru.serafim.web.models.State;
import ru.serafim.web.repositories.AccountsRepository;

import java.util.List;
import java.util.Optional;

import static ru.serafim.web.dto.AccountDto.from;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountsRepository accountsRepository;

    @Override
    public List<AccountDto> getAllAccountsWithoutDeleted() {
        return from(accountsRepository.findAllByStateNot(State.DELETED));
    }



    @Override
    public void delete(Long accountId) {
        Account account = accountsRepository.getById(accountId);
        account.setState(State.DELETED);
        accountsRepository.save(account);
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return accountsRepository.findById(id);
    }

    @Override
    public List<AccountDto> findAllAccounts() {
        return from(accountsRepository.findAll());
    }
}
