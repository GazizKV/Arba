package ru.serafim.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.serafim.web.models.Badge;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
}
