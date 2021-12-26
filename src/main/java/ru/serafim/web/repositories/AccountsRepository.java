package ru.serafim.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.serafim.web.dto.AccountDto;
import ru.serafim.web.models.Account;
import ru.serafim.web.models.State;

import java.util.List;
import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
    List<Account> findAllByStateNot(State state);
}
