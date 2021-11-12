package ru.serafim.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.serafim.web.models.ChillPlace;

public interface RestPlacesRepository extends JpaRepository<ChillPlace, Long> {
    ChillPlace findByName(String name);
}
