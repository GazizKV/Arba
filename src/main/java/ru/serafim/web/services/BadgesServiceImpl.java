package ru.serafim.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.serafim.web.models.Badge;
import ru.serafim.web.repositories.BadgeRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BadgesServiceImpl implements BadgesService {

    private final BadgeRepository badgeRepository;

    @Override
    public Optional<Badge> save(Badge badge) {
        Badge save = badgeRepository.save(badge);
        return Optional.of(save);
    }
}
