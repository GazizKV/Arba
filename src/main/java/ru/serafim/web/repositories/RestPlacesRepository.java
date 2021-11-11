package ru.serafim.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.serafim.web.models.RestingPlace;

public interface RestPlacesRepository extends JpaRepository<RestingPlace, Long> {
}
