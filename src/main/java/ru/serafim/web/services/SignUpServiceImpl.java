package ru.serafim.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.serafim.web.dto.SignUpForm;
import ru.serafim.web.models.Account;
import ru.serafim.web.models.State;
import ru.serafim.web.repositories.AccountsRepository;

import java.util.Locale;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final AccountsRepository accountsRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUp(SignUpForm form) {
        Account account = Account.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .email(form.getEmail().toLowerCase(Locale.ROOT))
                .role(Account.Role.USER)
                .state(State.NOT_CONFIRMED)
                .password(passwordEncoder.encode(form.getPassword()))
                .build();

        accountsRepository.save(account);
    }
}
