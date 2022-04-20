package ru.serafim.web.services;

import ru.serafim.web.models.Badge;

import java.util.Optional;

public interface BadgesService {

    Optional<Badge> save(Badge badge);
}
